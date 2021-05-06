$(function() {

    $("#sub").click(function() {

        var topfnum = $("#topfnum").val();
        var topsnum = $("#topsnum").val();
        var botfnum = $("#botfnum").val();
        var botsnum = $("#botsnum").val();
        var topresult = $("#topresult");
        var botresult = $("#botresult");

        $.ajax({
            url : 'calculate',
            method: 'GET',
            data : {
                topfnum : topfnum,
                topsnum : topsnum,
                botfnum : botfnum,
                botsnum : botsnum

            },
            success : function(responseText) {

               // alert(responseText["add"]);

                $('#topresult').val(responseText["add"]);
                $('#botresult').val(responseText["mul"]);
            }
        });



    });

});