package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.exception.SellCountException;
import com.cognizant.feignclient.AuthClient;
import com.cognizant.feignclient.MutualFundDetailsClient;
import com.cognizant.feignclient.StockDetailsClient;
import com.cognizant.model.AssetDetails;
import com.cognizant.model.SellAssetDetails;
import com.cognizant.repository.AssetRepository;
import com.netflix.discovery.EurekaClient;

@Service
public class CalculateNetworth {

	@Autowired
	AssetRepository assetRepository;

	// @Autowired
	// private RestTemplate restTemplate;

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	AuthClient authClient;

	@Autowired
	StockDetailsClient stockDetailsClient;

	@Autowired
	MutualFundDetailsClient mutualFundDetailsClient;

	public Boolean AuthorizeUser(String Header) {
		try {
			return authClient.verify(Header);
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public List<AssetDetails> getAllAssetForPortfolio(int id) {
		return assetRepository.findByPortfolioIdOrderByAssetId(id);
	}

	public List<Double> getSharePriceById(List<String> stockList, String header) {
		List<Double> stockValueList = new ArrayList<>();
		for (String stockId : stockList) {
			try {
				stockValueList.add(stockDetailsClient.getDailySharePriceStock(stockId, header));
			} catch (Exception e) {

				System.out.println("\n"+e+"\n");

			}
		}

		/*
		 * Application application = eurekaClient.getApplication("stock-service"); //var
		 * header = new HttpHeaders(); //header.set(HEADER, req); HttpHeaders headers =
		 * new HttpHeaders();
		 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 * //headers.setContentType(MediaType.APPLICATION_JSON); headers.set(req);
		 * HttpEntity<String> entity = new HttpEntity<String>(headers); InstanceInfo
		 * instanceInfo = application.getInstances().get(0); List<Double> stockValueList
		 * = new ArrayList<>(); for(String stockId:stockList) { String url = "http://" +
		 * instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" +
		 * "dailySharePriceById/" +stockId; double
		 * stockPrice=restTemplate.getForObject(url, Double.class);
		 * stockValueList.add(stockPrice); System.out.println("URL" + url); }
		 * System.out.println("RESPONSE " + stockValueList);
		 */
		return stockValueList;
	}

	public List<Double> getMutualFundUnitsById(List<String> mutualFundList, String header) {

		List<Double> mutualFundUnitsList = new ArrayList<>();
		for (String mutualFundId : mutualFundList) {
			mutualFundUnitsList.add(mutualFundDetailsClient.getMutualFundValue(mutualFundId));
		}
		/*
		 * Application application =
		 * eurekaClient.getApplication("dailymutualfundnav-service"); InstanceInfo
		 * instanceInfo = application.getInstances().get(0); List<Double>
		 * mutualFundUnitsList = new ArrayList<>(); for(String
		 * mutualFundId:mutualFundList) { String url = "http://" +
		 * instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" +
		 * "dailyMutualFundValueById/" +mutualFundId; double
		 * mutualFundValue=restTemplate.getForObject(url, Double.class);
		 * mutualFundUnitsList.add(mutualFundValue); System.out.println("URL" + url); }
		 * System.out.println("RESPONSE " + mutualFundUnitsList);
		 */
		return mutualFundUnitsList;
	}

	@Transactional
	public void sellAsset(SellAssetDetails sellAssetDetails) throws SellCountException {

		int portfolioId = sellAssetDetails.getId();
		String assetId = sellAssetDetails.getAssetId();
		var assetDetails = assetRepository.findByPortfolioIdAndAssetId(portfolioId, assetId);
		int count = assetDetails.getAssetcount();
		int sellCount = sellAssetDetails.getAssetcount();
		if (sellCount > count) {
			throw new SellCountException("Sell count should be less than the available count");
		}
		if (count == sellCount) {
			assetRepository.deleteByPortfolioIdAndAssetId(portfolioId, assetId);
		} else {
			count -= sellCount;
		}
		assetDetails.setAssetcount(count);
		assetRepository.save(assetDetails);
	}

}
