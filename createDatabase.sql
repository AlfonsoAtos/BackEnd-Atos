create table RegisteredUser (
    userID numeric primary key,
    userEmail varchar(25) not null unique,
    userPassword varchar(30) not null,
    userFullName varchar(20) not null,
    userAddress varchar(40) not null,
    userContactNo varchar(30) not null,
    userRole numeric not null -- 1 == user, 10 == admin
);

create table ProductCategory (
    productCategoryID numeric primary key,
    categoryName varchar(15) not null unique,
    categoryDescription varchar(30)
);

create table Product (
    productID numeric primary key,
    productName varchar(50) not null,
    productCompany varchar(20) not null,
    productPrice number not null,
    productDescription varchar(500),
    productImagePath varchar(50),
    productCategoryID numeric references ProductCategory(productCategoryID) not null
);

create table PromotionEvent (
    promotionEventID numeric primary key,
    promotionEventName varchar(15) not null,
    promotionEventDescription varchar(30) not null,
    promotionEventStartDate date not null,
    promotionEventEndDate date not null,
    promotionEventStatus varchar(10) not null constraint chkpromotionEventStatus check (promotionEventStatus in ('Valid','Expired','Cancelled')),
    adminID numeric references RegisteredUser(userID) not null
);

create table Coupon (
    couponID numeric primary key,
    couponName varchar(15) not null unique,
    couponCode varchar(15) not null,
    couponType varchar(10) not null constraint chkcouponType check (couponType in ('Open','Not open')),
    couponDiscount numeric not null,
    promotionEventID numeric references PromotionEvent(promotionEventID) not null,
    productCategoryID numeric references ProductCategory(productCategoryID)
    
);

create table ShoppingCart(
    shoppingCartID numeric primary key,
    creationDate date,
    cartStatus varchar(10) not null constraint chkcartStatus check (cartStatus in ('Complete','Insession')),
    userID numeric references RegisteredUser(userID) not null
);

create table ShoppingProductDetails (
    shoppingProductDetailsID numeric primary key,
    quantity numeric not null,
    shoppingCost number,
    costAfterApplyingCoupon number,
    productID numeric references Product(productID) not null,
    shoppingCartId numeric references ShoppingCart(shoppingCartID) not null
);

create table Payment(
    paymentID numeric primary key,
    openCoupon numeric,
    shoppingFinalAmount numeric,
    paymentStatus varchar(15) not null constraint chkpaymentStatus check (paymentStatus in ('Complete','InNegotiation')),
    shoppingCartID numeric references ShoppingCart(shoppingCartID) not null
);

insert into RegisteredUser values(1, 'admin@admin.com', 'pass123', 'admin', 'adress', '1234567890', 10);
insert into RegisteredUser values(2, 'user@user.com', 'pass123', 'user', 'adress', '1234567890', 1);

insert into productCategory values (1, 'Shooter', 'Shooter video games.');
insert into productCategory values (2, 'RPG', 'RPG video games.');
insert into productCategory values (3, 'Simulation', 'Simulation video games.');
insert into productCategory values (4, 'VR', 'VR video games.');
insert into productCategory values (5, 'Strategy', 'Strategy video games.');

insert into Product values (1, 'Doom Eternal', 'Epic Games', 60.00, 'Hell''s armies have invaded Earth. Become the Slayer in an epic single-player campaign to conquer demons across dimensions and stop the final destruction of humanity. Armed with a shoulder-mounted flamethrower, retractable wrist-mounted blade, upgraded guns and mods, and abilities, you''re faster, stronger, and more versatile than ever. Take what you need from your enemies: Glory kill for extra health, incinerate for armor, and chainsaw demons to stock up on ammo.', 'doom-eternal.jpg', 1);
insert into Product values (2, 'Grand Theft Auto 5', 'Rockstar Games', 30.50, 'The biggest, most dynamic and most diverse open world ever created, Grand Theft Auto V blends storytelling and gameplay in new ways as players repeatedly jump in and out of the lives of the game''s three lead characters, playing all sides of the game''s interwoven story. Three very different criminals plot their own chances of survival and success. Running out of options, the crew risks everything in a series of daring and dangerous heists that could set them up for life.', 'gta-5.jpg', 1);
insert into Product values (3, 'Rust', 'Facepunch Studios', 18.30, 'You wake naked on a mysterious island armed only with a rock and a torch. You''ll need to brave natural dangers, from heat and cold to thirst and starvation. Rust features crafting, though initially limited until the discovery of specific items in the game''s open world. To stay protected, players must build bases or join clans to improve their chance of survival.', 'rust.png', 1);
insert into Product values (4, 'Monster Hunter World', 'Capcom', 15.99, 'Battle gigantic monsters in epic locales. As a hunter, you''ll take on quests to hunt monsters in a variety of habitats. Take down these monsters and receive materials that you can use to create stronger weapons and armor in order to hunt even more dangerous monsters. In Monster Hunter: World, the latest installment in the series, you can enjoy the ultimate hunting experience, using everything at your disposal to hunt monsters in a new world teeming with surprises and excitement.', 'monster-hunter-world.jpg', 2);
insert into Product values (5, 'The Witcher 3', 'CD Projekt Red', 17.2, 'The Witcher 3 is a story-driven open world RPG set in a visually stunning fantasy universe full of meaningful choices and impactful consequences. In The Witcher, you play as professional monster hunter Geralt of Rivia tasked with finding a child of prophecy in a vast open world rich with merchant cities, pirate islands, dangerous mountain passes, and forgotten caverns to explore.', 'the-witcher-3.png', 2);
insert into Product values (6, 'Farming Simulator 22', 'GIANTS Software', 18, 'Take on the role of a modern farmer and creatively build your farm in three diverse American and European environments. Farming Simulator 22 offers a huge variety of farming operations focusing on agriculture, animal husbandry and forestry - now with the exciting addition of seasonal cycles!', 'farming-simulator-22.jpg', 3);
insert into Product values (7, 'Stardew Valley', 'ConcernedApe', 10, 'Stardew Valley is an open-ended country-life RPG! You''ve inherited your grandfather''s old farm plot in Stardew Valley. Armed with hand-me-down tools and a few coins, you set out to begin your new life. Can you learn to live off the land and turn these overgrown fields into a thriving home? It won''t be easy. Ever since Joja Corporation came to town, the old ways of life have all but disappeared.', 'stardew-valley.png', 3);
insert into Product values (8, 'PvZ BFN', 'PopCap Games', 44, 'Prepare to Kick Some Grass! Welcome to Neighborville, where all is well. Except that a crazy new coniferous conflict between brain-less and botanicals is brewing! What are you gonna do, call the crops? Soil your plants? Join forces with other players to experience split-screen couch co-op in every mode, connect with up to three players and battle through flourishing free-roam regions or jump into the fray with up to 24 players in online multiplayer across a gigantic suburban skirmish.', 'pvz-neighborville.jpg', 1);
insert into Product values (9, 'Skyrim: VR', 'Bethesda', 30, 'Control powerful mechs from the future to defeat an alien threat. Each attempt to save the world presents a new randomly generated challenge in this turn-based strategy game.', 'skyrim vr.jpg', 4);
insert into Product values (10, 'SUPERHOT: VR', 'SUPERHOT Team', 5, 'Lose track of what''s real. Commit yourself, body and mind. Confront the evocative, elegantly brutal world of SUPERHOT VR. Enemies pouring into the room from all sides, dozens of bullets coursing through the air... Wait. Something seems different in here...', 'super hot vr.jpg', 4);
insert into Product values (11, 'Beat Saber', 'Beat Games', 50, 'Beat Saber is a VR rhythm game where you slash the beats of adrenaline-pumping music as they fly towards you, surrounded by a futuristic world.', 'beat-saber.jpg', 4);
insert into Product values (12, 'Apex Legends', 'Respawn', 10, 'Apex Legends is the award-winning, free-to-play Hero shooter from Respawn Entertainment. Master an ever-growing roster of legendary characters with powerful abilities and experience strategic squad play and innovative gameplay in the next evolution of Hero Shooter and Battle Royale.', 'apex legends.jpg', 1);
insert into Product values (13, 'Halo Infinite', '343 Industries', 60, 'The legendary Halo series returns with the most expansive Master Chief campaign yet and a ground-breaking free to play multiplayer experience.', 'halo infinite.jpg', 1);
insert into Product values (14, 'Titanfall 2', 'Respawn', 15, 'Respawn Entertainment gives you the most advanced titan technology in its new, single player campaign & multiplayer experience. Combine & conquer with new titans & pilots, deadlier weapons, & customization and progression systems that help you and your titan flow as one unstoppable killing force.', 'titanfall 2.jpg', 1);
insert into Product values (15, 'Into the Breach', 'Subset Games', 5, 'Control powerful mechs from the future to defeat an alien threat. Each attempt to save the world presents a new randomly generated challenge in this turn-based strategy game.', 'into the breach.jpg', 5);
insert into Product values (16, 'Total War: WARHAMMER 2', 'Creative Assembly', 5, 'The cataclysmic conclusion to the Total War: WARHAMMER trilogy is coming. Rally your forces and step into the Realm of Chaos, a dimension of mind-bending horror where the very fate of the world will be decided. Will you conquer your Daemons… or command them?', 'warhammer 2.jpg', 5);
insert into Product values (17, 'XCOM 2', '2k', 5, 'XCOM 2 is the sequel to XCOM: Enemy Unknown, the 2012 award-winning strategy game of the year. Earth has changed and is now under alien rule. Facing impossible odds you must rebuild XCOM, and ignite a global resistance to reclaim our world and save humanity.', 'xcom 2.jpg', 5);
insert into Product values (18, 'Transistor', 'Supergiant', 15, 'Transistor is a sci-fi themed action RPG that invites you to wield an extraordinary weapon of unknown origin as you fight through a stunning futuristic city. Transistor seamlessly integrates thoughtful strategic planning into a fast-paced action experience, melding responsive gameplay and rich atmospheric storytelling. During the course of the adventure, you will piece together the Transistor"s mysteries as you pursue its former owners.', 'transistor.jpg', 5);
insert into Product values (19, 'Pyre', 'Supergiant', 15, 'Pyre is a party-based RPG from the creators of Bastion and Transistor. Lead your band of exiles to freedom through a series of mystical competitions in the Campaign, or challenge a friend to a fast-paced ritual showdown in the head-to-head Versus Mode.', 'pyre.jpg', 2);
insert into Product values (20, 'Hades', 'Supergiant', 15, 'Defy the god of the dead as you hack and slash out of the Underworld in this rogue-like dungeon crawler from the creators of Bastion, Transistor, and Pyre.', 'hades.jpg', 2);
insert into Product values (21, 'Half Life: Alyx', 'Valve', 30, 'Half-Life: Alyx is Valve''s VR return to the Half-Life series. It''s the story of an impossible fight against a vicious alien race known as the Combine, set between the events of Half-Life and Half-Life 2. Playing as Alyx Vance, you are humanity’s only chance for survival.', 'half life alyx.jpg', 4);

INSERT INTO PromotionEvent VALUES (1, 'test2022', 'Discount test2022', TO_DATE('2022-01-21 17:09:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2022-01-29 17:10:03', 'YYYY-MM-DD HH24:MI:SS'), 'Valid', 1);
INSERT INTO PromotionEvent VALUES (2, 'test2023', 'Discount test2023', TO_DATE('2022-01-21 17:40:24', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2022-01-29 17:40:28', 'YYYY-MM-DD HH24:MI:SS'), 'Expired', 1);

insert into coupon values( 1, 'Black Friday', 'YZX12345',  'Open',  20, 1, 1);
insert into coupon values( 2, 'Christmas', 'HDKA6445J', 'Not open', 53, 1, 1);

