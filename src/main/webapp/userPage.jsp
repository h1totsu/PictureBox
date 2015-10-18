<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css" />
    <script src="https://code.jquery.com/jquery-2.1.4.js"></script>
    <script src="js/global.js"></script>
</head>
<body>
<div class="overlay"></div>
<div class="form-add-photo">
    <div class="close">
        <i class="fa fa-close"></i>
    </div>
    <form action="upload" method="POST" enctype="multipart/form-data">
        <img src="images/profile.jpg" />
        <input type="file" name="file" id="file" />
        <input placeholder="Enter tags" name="tags" id="tags" type="text"/>
        <textarea name="description" id="description" cols="30" rows="10"></textarea>
        <input id="submit" type="submit"/>
    </form>
</div>

<div class="form-log-in">
    <div class="close">
        <i class="fa fa-close"></i>
    </div>
    <form class="login-form" action="login">
        <img class="f-log-img" src="images/profile.jpg" alt="Avatar" />
        <input class="login" name="login" type="text" placeholder="Username" />
        <input class="password" name="password" type="password" placeholder="Password" />
        <input class="log-button" type="submit" />
        <div class="message"></div>
    </form>
</div>
<section class="sidebar">
    <a href="#" class="logo">
        <img src="images/logo.jpg" alt="Profile"/>
    </a>
    <div class="search-box">
        <input placeholder="Search" type="text"/>
        <a href="#" class="search-button">
            <i class="fa fa-search"></i>
        </a>
    </div>
    <nav class="sidebar-nav" role="navigation">
        <ul>
            <li><a class="active" href="#">Home</a></li>
            <li><a href="#">Pesni</a></li>
            <li><a href="#">Plyaski</a></li>
            <li><a href="#">Tansi</a></li>
        </ul>
    </nav>
    <div class="devider"></div>
    <nav class="sidebar-user-nav">
        <ul>
            <li><a href="#"><i class="fa fa-picture-o"></i>My images</a></li>
            <li><a href="#"><i class="fa fa-heart"></i>Favourites</a></li>
            <li><a href="#"><i class="fa fa-cloud-download"></i>Downloads</a></li>
            <li><a href="#"><i class="fa fa-eye"></i>Views</a></li>
        </ul>
    </nav>
    <a href="#" class="upload-photo"><i class="fa fa-plus"></i>Add image</a>
    <div class="user-box">
        <div class="devider"></div>
        <img class="user-image" src="images/profile.jpg" alt="Profile"/>
        <div class="user-control clearfix">
            <a href="#" class="profile">Profile</a>
            <a href="/index.jsp" class="log-out">Log-out</a>
        </div>
    </div>
</section>

<header class="header">
</header>

<section class="main-content">
    <div class="grid clearfix">
        <div class="column-3">
            <a class="link" href="#">
                <div class="image" style="background-image: url('images/img1.jpg');"></div>
                <div class="info-panel clearfix">
                    <div class="date"><%= session.getAttribute("user") %></div>
                    <div class="services clearfix">
                        <div class="service views">
                            <i class="fa fa-eye"></i>
                            43
                        </div><!-- end of .service -->
                        <div class="service likes">
                            <i class="fa fa-heart"></i>
                            10
                        </div><!-- end of .service -->
                        <div class="service downloads">
                            <i class="fa fa-cloud-download"></i>
                            4
                        </div><!-- end of .service -->
                    </div><!-- end of .services -->
                </div><!-- end of .info-panel -->
            </a>
            <div class="popup-content clearfix">
                <div class="close">
                    <i class="fa fa-close"></i>
                </div>
                <div class="image">
                    <img src="images/img1.jpg" alt="Image name"/>
                </div>
                <div class="info-panel clearfix">
                    <div class="author">
                        Added by
                        <a href="#" class="name">Adell</a>
                        on <span class="date">03.10.2015</span>
                    </div>
                    <div class="services clearfix">
                        <div class="service views">
                            <i class="fa fa-eye"></i>
                            43
                        </div><!-- end of .service -->
                        <div class="service likes">
                            <i class="fa fa-heart"></i>
                            10
                        </div><!-- end of .service -->
                        <div class="service downloads">
                            <i class="fa fa-cloud-download"></i>
                            4
                        </div><!-- end of .service -->
                    </div><!-- end of .services -->
                </div><!-- end of .info-panel -->
                <div class="info">
                    <p class="description">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                        Asperiores eos harum molestias nihil porro recusandae rem tempore?
                    </p>
                    <div class="tags">
                        <a href="#">#sea</a>
                        <a href="#">#friends</a>
                        <a href="#">#USA</a>
                        <a href="#">#ice-cream</a>
                        <a href="#">#hot</a>
                        <a href="#">#weekend</a>
                    </div>
                </div>
                <div class="actions clearfix">
                    <a href="#" class="like">
                        <i class="fa fa-heart"></i>
                        Add to Favorites
                    </a>
                    <a href="#" class="download">
                        <i class="fa fa-cloud-download"></i>
                        Download
                    </a>
                </div>
                <div class="clearfix"></div>
                <div class="comments">
                    <h4 class="comments-title">Comments</h4>
                    <div class="comment clearfix">
                        <div class="comment-text">Покупал для ребенка переговариваться во время велосипедных прогулок. Отлично за такие деньги. Ведь практически все рации (для кот не требуется разрешение Укрчастотнагляда) все равно работают в одном частотном диапазоне, одинаковая выходная мощность до 0,5 Вт. Везде 8 открытых каналов и одинаковый тип модуляции.</div>
                        <div class="author clearfix">
                            <img class="photo" src="images/profile.jpg" alt="Author"/>
                            <div class="text">
                                <a href="#" class="name">Viktoria Beckham</a>
                                <div class="date">10.10.2015</div>
                            </div>
                        </div>
                    </div>
                    <div class="comment clearfix">
                        <div class="comment-text">Везде 8 открытых каналов и одинаковый тип модуляции.</div>
                        <div class="author clearfix">
                            <img class="photo" src="images/profile.jpg" alt="Author"/>
                            <div class="text">
                                <a href="#" class="name">Viktoria Beckham</a>
                                <div class="date">10.10.2015</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- end of .popup-content -->
        </div>
    </div>
</section>

<footer class="footer">

</footer>

</body>
</html>