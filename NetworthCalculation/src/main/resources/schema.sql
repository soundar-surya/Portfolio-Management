create table portfolio (portfolio_id int primary key);

create table asset (aid int primary key,asset_id varchar(20),portfolio_id int,type varchar(10),units int, foreign key(portfolio_id) references portfolio(portfolio_id));