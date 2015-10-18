$(document).ready(function(){
    $('.grid .column-3 .link').click(function(){
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
    $('.page-link').click(function() {
        $.ajax({
            url: '/images',
            type: 'GET',
            data: 'page=' + $(this).text(),
            success: function(json) {
                $('.grid').empty();
                for(i=0; i < Object.keys(json).length; i++) {
                    var column3 = $('<div class="column-3" />').appendTo($('.grid'));
                        var link = $('<a class="link" href="#" />').appendTo(column3);
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
    });
});