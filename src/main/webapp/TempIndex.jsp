<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8" />
    <title>Home Page of Sayub</title>
    <link rel="stylesheet" href="style1.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
    <div class="scroll-button">
        <a href="#home"><i class="fas fa-arrow-up"></i></a>
    </div>
    <nav>
        <div class="navbar">
            <div class="logo">
                <% 
                    HttpSession sessions = request.getSession(false);
                    String currentUser = (String) sessions.getAttribute("currentUser");
                %>
                <p>Current User: <% out.println(currentUser); %></p>
            </div>
            <div class="menu-btn">
                <i class="fas fa-bars"></i>
            </div>;
            <ul class="menu">
                <li><a href="#home">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#skills">Product</a></li>
                <li><a href="#services">Services</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
            <div class="media-icons">
                <a href="#"><i class="fab fa-facebook-f"></i></a>
                <a href="#"><i class="fab fa-twitter"></i></a>
                <a href="#"><i class="fab fa-instagram"></i></a>
                <a href='LogoutServlet'>Logout</a>
            </div>
        </div>
    </nav>

    <section class="home" id="home">
        <div class="home-content">
            <!-- Existing home content here -->
            <div class="box">
                <p><a href='NewUser.jsp'>New User</a></p>
                <p><a href='SearchUser.jsp'>Search User</a></p>
            </div>
        </div>
    </section>

    <section class="skills" id="skills">
        <div class="content">
            <div class="title"><span>Product</span></div>
            <div class="skills-details">
                <div class="text">
                    <div class="topic">Skills Reflects Our Knowledge</div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minus natus tenetur tempora? Quasi, rem quas omnis. Porro rem aspernatur reiciendis ut praesentium minima ad, quos, officia! Illo libero, et, distinctio repellat sed nesciunt est modi quaerat placeat. Quod molestiae, alias?</p>
                    <div class="experience">
                        <div class="num">10</div>
                        <div class="exp">
                            Years Of <br />
                            Experience
                        </div>
                    </div>
                </div>
                <div class="boxes">
                    <div class="box">
                        <div class="topic">HTML</div>
                        <div class="per">90%</div>
                    </div>
                    <div class="box">
                        <div class="topic">CSS</div>
                        <div class="per">80%</div>
                    </div>
                    <div class="box">
                        <div class="topic">JavaScript</div>
                        <div class="per">70%</div>
                    </div>
                    <div class="box">
                        <div class="topic">PHP</div>
                        <div class="per">60%</div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="services" id="services">
        <div class="content">
            <div class="title"><span>Services</span></div>
            <div class="boxes">
                <div class="box">
                    <div class="icon">
                        <i class="fas fa-desktop"></i>
                    </div>
                    <div class="topic">Web Development</div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia autem quam odio, qui voluptatem eligendi?</p>
                </div>
                <div class="box">
                    <div class="icon">
                        <i class="fas fa-paint-brush"></i>
                    </div>
                    <div class="topic">Graphic Design</div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia autem quam odio, qui voluptatem eligendi?</p>
                </div>
                <div class="box">
                    <div class="icon">
                        <i class="fas fa-chart-line"></i>
                    </div>
                    <div class="topic">Digital Marketing</div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia autem quam odio, qui voluptatem eligendi?</p>
                </div>
                <div class="box">
                    <div class="icon">
                        <i class="fab fa-android"></i>
                    </div>
                    <div class="topic">Icon Design</div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia autem quam odio, qui voluptatem eligendi?</p>
                </div>
                <div class="box">
                    <div class="icon">
                        <i class="fas fa-camera-retro"></i>
                    </div>
                    <div class="topic">Photography</div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia autem quam odio, qui voluptatem eligendi?</p>
                </div>
                <div class="box">
                    <div class="icon">
                        <i class="fas fa-tablet-alt"></i>
                    </div>
                    <div class="topic">App Development</div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia autem quam odio, qui voluptatem eligendi?</p>
                </div>
            </div>
        </div>
    </section>

    <section class="contact" id="contact">
        <div class="content">
            <div class="title"><span>Contact Me</span></div>
            <div class="text">
                <div class="topic">Have Any Project?</div>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsam neque ipsum corrupti dolores, facere numquam voluptate aspernatur sit perferendis qui nisi modi! Recusandae deserunt consequatur voluptatibus alias repellendus nobis eligendi.</p>
                <div class="button">
                    <button>Let's Chat</button>
                </div>
            </div>
        </div>
    </section>

    <footer>
        <div class="text">
            <span>Created By <a href="#">Sayub Shakya</a> | &#169; 2021 All Rights Reserved</span>
        </div>
    </footer>

    <script src="script1.js"></script>
</body>
</html>
