create table Admin(
    adminID numeric primary key,
    adminName varchar(20) not null,
    email varchar(25) not null unique,
    adminPassword varchar(30) not null
);

create table RegisteredUser (
    userID numeric primary key,
    userLoginID varchar(25) not null unique,
    userPassword varchar(30) not null,
    userFullName varchar(20) not null,
    userAddress varchar(40) not null,
    userContactNo varchar(30) not null
);

insert into Admin values(1, 'Alberto' , 'al@al.com', 'pass123');

create table ProductCategory (
    productCategoryID numeric primary key,
    categoryName varchar(15) not null unique,
    categoryDescription varchar(30)
);

insert into productCategory values (1, 'Shooter', 'Shooter video games.');
insert into productCategory values (2, 'RPG', 'RPG video games.');
insert into productCategory values (3, 'Simulation', 'Simulation video games.');
insert into productCategory values (4, 'VR', 'VR video games.');
insert into productCategory values (5, 'Strategy', 'Strategy video games.');

create table Product (
    productID numeric primary key,
    productName varchar(20) not null,
    productCompany varchar(20) not null,
    productPrice numeric not null,
    productDescription varchar(30),
    productImagePath varchar(50),
    productCategoryID numeric references ProductCategory(productCategoryID) not null
);

insert into Product values (6, 'Farming Simulator 22', 'GIANTS Software', 18, 'FS22 description', 'farming-simulator-22.jpg', 3);
insert into Product values (7, 'Stardew Valley', 'ConcernedApe', 7.38, 'Stardew Valley description.', 'stardew-valley.png', 3);
insert into Product values (8, 'dsfsdf Valley', 'sfs', 7.38, 'sdf Valley description.', 'stardewsdfvalley.png', 1);
insert into Product values (9, 'PvZ BFN', 'PopCap Games', 44, 'PvZ BFN description.', 'pvz-neighborville.jpg', 1);

create table PromotionEvent (
    promotionEventID numeric primary key,
    promotionEventName varchar(15) not null,
    promotionEventDescription varchar(30) not null,
    promotionEventStartDate date not null,
    promotionEventEndDate date not null,
    promotionEventStatus varchar(10) not null constraint chkpromotionEventStatus check (promotionEventStatus in ('Valid','Expired','Cancelled')),
    adminID numeric references Admin(adminID) not null
);

INSERT INTO "SYSTEM"."PROMOTIONEVENT" (PROMOTIONEVENTID, PROMOTIONEVENTNAME, PROMOTIONEVENTDESCRIPTION, PROMOTIONEVENTSTARTDATE, PROMOTIONEVENTENDDATE, PROMOTIONEVENTSTATUS, ADMINID) VALUES ('1', 'test2022', 'Discount test2022', TO_DATE('2022-01-21 17:09:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2022-01-29 17:10:03', 'YYYY-MM-DD HH24:MI:SS'), 'Valid', '1');

INSERT INTO "SYSTEM"."PROMOTIONEVENT" (PROMOTIONEVENTID, PROMOTIONEVENTNAME, PROMOTIONEVENTDESCRIPTION, PROMOTIONEVENTSTARTDATE, PROMOTIONEVENTENDDATE, PROMOTIONEVENTSTATUS, ADMINID) VALUES ('2', 'test2023', 'Discount test2023', TO_DATE('2022-01-21 17:40:24', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2022-01-29 17:40:28', 'YYYY-MM-DD HH24:MI:SS'), 'Expired', '1');

create table Coupon (
    couponID numeric primary key,
    couponName varchar(15) not null unique,
    couponType varchar(10) not null constraint chkcouponType check (couponType in ('Open','Nopen')),
    couponDiscount numeric not null,
    promotionEventID numeric references PromotionEvent(promotionEventID) not null,
    productCategoryID numeric references ProductCategory(productCategoryID),
    couponCode VARCHAR2(15 BYTE) NOT NULL UNIQUE
);

drop table Coupon;

insert into coupon values( 1,   'Black Friday',  'Open',  20, 1, 1,  'YZX12345');
insert into coupon values( 2, 'Christmas', 'Nopen', 53, 1, 1, 'HDKA6445J');

create table ShoppingCart(
    shoppingCartID numeric primary key,
    creationDate date,
    cartStatus varchar(10) not null constraint chkcartStatus check (cartStatus in ('Complete','Insession')),
    userID numeric references RegisteredUser(userID) not null
);

create table ShoppingProductDetails (
    shoppingProductDetailsID numeric primary key,
    quantity numeric not null,
    shoppingCost numeric,
    costAfterApplyingCoupon numeric,
    productID numeric references Product(productID) not null unique,
    shoppingCartId numeric references ShoppingCart(shoppingCartID) not null
);

create table Payment(
    paymentID numeric primary key,
    openCoupon numeric,
    shoppingFinalAmount numeric,
    paymentStatus varchar(15) not null constraint chkpaymentStatus check (paymentStatus in ('Complete','InNegotiation')),
    shoppingCartID numeric references ShoppingCart(shoppingCartID) not null
);