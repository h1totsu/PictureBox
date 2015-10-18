$(document).ready(function(){
    loadPage(1);
    loadPagination();
    $('.grid .column-3 .link').click(function(e){
        $('.overlay').fadeIn(400);
        $(this).parent().find('.popup-content').fadeIn(300);
    });
    $('.popup-content .close, .overlay, .form-add-photo .close, .form-log-in .close').click(function(){
        $('.overlay').fadeOut(200);
        $('.popup-content').fadeOut(200);
        $('.form-add-photo').fadeOut(300);
        $('.form-log-in').fadeOut(300);
    });
    $('.upload-photo').click(function(){
        $('.overlay').fadeIn(400);
        $('.form-add-photo').fadeIn(300);
    });
    $('.log-in').click(function() {
        $('.overlay').fadeIn(400);
        $('.form-log-in').fadeIn(300);
    });
    $('.login-form').submit(function() {
        $.ajax({
            url: 'login',
            type: 'GET',
            contentType: false,
            processData: false,
            data: 'login=' + $('.login').val() +'&password=' + $('.password').val(),
            success: function(logged) {
                if(logged == "true") {
                    window.location.href = '/userpage';
                } else {
                    $('.message').html('Invalid username or password')
                }
            }
        });
        return false;
    });

    function loadPage(page) {
        $.ajax({
            url: '/images',
            type: 'GET',
            data: 'page=' + page,
            success: function(json) {
                $('.grid').empty();
                for(i=0; i < Object.keys(json).length; i++) {
                    var column3 = $('<div class="column-3" />').appendTo($('.grid'));
                    var link = $('<a class="link" href="#" />').appendTo(column3);
                        link.click(function() {
                            $('.overlay').fadeIn(400);
                            $(this).parent().find('.popup-content').fadeIn(300);
                        });
                    var image = $('<div class="image" style="background-image: ' +
                        'url(data:image/jpg;base64,' + json[i].img + ');" />').appendTo(link); // image
                    var infoPanel = $('<div class="info-panel clearfix" />').appendTo(link);
                    var date = $('<div class="date" />').text(json[i].date).appendTo(infoPanel); // date
                    var services = $('<div class="services clearfix" />').appendTo(infoPanel);
                    var serviceViews = $('<div class="service views" />').appendTo(services);
                    var i_sw = $('<i class="fa fa-eye" />').appendTo(serviceViews);
                    serviceViews.append('\n' + json[i].likes); // views
                    var serviceLikes = $('<div class="service likes" />').appendTo(services);
                    var i_slk = $('<i class="fa fa-heart" />').appendTo(serviceLikes);
                    serviceLikes.append('\n' + json[i].likes); // likes
                    var serviceLoads = $('<div class="service downloads" />').appendTo(services);
                    var i_sl = $('<i class="fa fa-cloud-download" />').appendTo(serviceLoads);
                    serviceLoads.append('\n' + json[i].loads); // downloads
                    //=================================================================
                    var popup = $('<div class="popup-content clearfix" />');
                }
            }
        });
        return false;
    }

    function loadPagination() {
        $.ajax({
            url: '/pagination',
            success: function(data) {
                var pages = parseInt(data);
                var link = '/images?page=';

                $('<a class="page-link outside" />').text('First').attr('href', link + 1)
                    .appendTo($('.pagination'));
                for(i = 1; i <= pages; i++) {
                    var pageLink = $('<a class="page-link" />').text(i).attr('href', link + i)
                        .appendTo($('.pagination'));
                }
                if(pages > 7) {
                    if(i == 4) {
                        $('<span class="page-link" />').text('...').appendTo($('.pagination'));
                    }
                    $('<a class="page-link" />').text(pages-1).attr('href', link + pages-1)
                        .appendTo($('.pagination'));
                    $('<a class="page-link" />').text(pages).attr('href', link + pages)
                        .appendTo($('.pagination'));
                }
                $('<a class="page-link outside" />').text('Last').attr('href', link + pages)
                    .appendTo($('.pagination'));

                $('.page-link').click(function() {
                    loadPage($(this).text());
                    return false;
                });
            }
        });
        return false;
    }

});