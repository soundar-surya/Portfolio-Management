const express = require('express')
const bodyParser = require('body-parser')
const axios = require('axios')
// const stocks = require('./stockSymbols.json')
const {key} = require('./keys')

// app config
const app = express()

// routes
app.get('/stocks', (req, res) => {
    console.log(key)
    res.send(stocks)
})

app.get('/daily/:symbol', async (req, res) => {
    const {symbol} = req.params
    let currentPrice = {}
    let {data} = await axios.get(`https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=${symbol}&apikey=${key}`)
    data = Object.values(data)
    currentPrice = Object.values(data[1])[0]
    res.send(JSON.stringify(currentPrice))
})

// server config
const PORT  = 5000 || process.env.PORT;
app.listen(PORT, () => console.info(`server running on  port:${PORT}`))
