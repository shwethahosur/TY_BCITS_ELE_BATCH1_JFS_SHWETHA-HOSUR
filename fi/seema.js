$(document).ready(function () {
    $flag = 1;
    /***** Personal Data Validation ****/
    $("#name").focusout(function () {
        if ($(this).val() == '') {
            $(this).css("border-color", "#cd2d00");
            $('#submit').attr('disabled', true);
            $("#error_name").text("* You have to enter your first name!");
        } else {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled', false);
            $("#error_name").text("");

        }
    });
    $("#lastname").focusout(function () {
        if ($(this).val() == '') {
            $(this).css("border-color", "#cd2d00");
            $('#submit').attr('disabled', true);
            $("#error_lastname").text("* You have to enter your last name!");
        } else {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled', false);
            $("#error_lastname").text("");
        }
    });
    $("#dob").focusout(function () {
        if ($(this).val() == '') {
            $(this).css("border-color", "#cd2d00");
            $('#submit').attr('disabled', true);
            $("#error_dob").text("* You have to enter your Date of Birth!");
        } else {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled', false);
            $("#error_dob").text("");
        }
    });

    /***** Email Validation ****/

    function validateEmail(sEmail) {
        var filter = /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/;
        if (filter.test(sEmail)) {
            return true;
        } else {
            return false;
        }
    }
    $("#email").focusout(function () {
        var sEmail = $('#email').val();
        if ($.trim(sEmail).length == 0) {
            $(this).css("border-color", "#cd2d00");
            $('#submit').attr('disabled', true);
            $("#error_email").text("Please enter valid email address");

            e.preventDefault();
        }
        if (validateEmail(sEmail)) {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled', false);
            $("#error_email").text("");;
        } else {
            $(this).css("border-color", "#cd2d00");
            $('#submit').attr('disabled', true);
            $("#error_email").text("Invalid email address");
            e.preventDefault();
        }
    });
    /***** Login Data Validation ****/


    $("#username").focusout(function () {
        if ($(this).val() == '') {
            $(this).css("border-color", "#cd2d00");
            $('#submit').attr('disabled', true);
            $("#error_username").text("* You have to enter your Username!");
        } else {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled', false);
            $("#error_username").text("");
        }
    });
    $("#password").focusout(function () {
        if ($(this).val() == '') {
            $(this).css("border-color", "#cd2d00");
            $('#submit').attr('disabled', true);
            $("#error_password").text("* You have to enter your Password!");
        } else {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled', false);
            $("#error_password").text("");
        }
    });
    $("#confirm").focusout(function () {
        if ($("#confirm").val() !== $("#password").val()) {
            $("#confirm").css("border-color", "#cd2d00");
            $('#submit').attr('disabled', true);
            $("#error_confirm").text("Passwords Do not match!");
        } else {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled', false);
            $("#error_confirm").text("");
        }
    });

    /***+* Submit Validation ****/
    $("#submit").click(function () {
        if ($("#name").val() == '') {
            $("#name").css("border-color", "#cd2d00");
            $('#submit').attr('disabled', true);
            $("#error_name").text("* You have to enter your first name!");
        }
        if ($("#lastname").val() == '') {
            $("#lastname").css("border-color", "#cd2d00");
            $('#submit').attr('disabled', true);
            $("#error_lastname").text("* You have to enter your Last name!");
        }
        if ($("#dob").val() == '') {
            $("#dob").css("border-color", "#cd2d00");
            $('#submit').attr('disabled', true);
            $("#error_dob").text("* You have to enter your Date of Birth!");
        }
        if ($("#email").val() == '') {
            $("#email").css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_email").text("* You have to enter your Email  !");
        }
        if ($("#username").val() == '') {
            $("#username").css("border-color", "#cd2d00");
            $('#submit').attr('disabled', true);
            $("#error_username").text("* You have to enter your Username!");
        }
        if ($("#password").val() == '') {
            $("#password").css("border-color", "#cd2d00");
            $('#submit').attr('disabled', true);
            $("#error_password").text("Enter a Password");
        }
        if ($("#confirm").val() == '') {
            $("#confirm").css("border-color", "#cd2d00");
            $('#submit').attr('disabled', true);
            $("#error_confirm").text("Confirm Password");
        }

    });


});