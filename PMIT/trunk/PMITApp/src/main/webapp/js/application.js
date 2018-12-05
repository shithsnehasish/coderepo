jQuery.validator.addMethod('dell', function (value, element) {
return this.optional(element) ||/^([a-zA-Z0-9]+){3,}[._]([a-zA-Z0-9]){1,}@dell\.com$/i.test(value);
}, "not a valid dell email address");
jQuery.validator.addMethod("exactlength", function(value, element, param) {
 return this.optional(element) || value.length == param;
}, jQuery.format("Please enter exactly {0} characters."));
jQuery.validator.addMethod("lettersonly", function(value, element) {
  return this.optional(element) || /^[A-Za-z ]+$/i.test(value);
}, "Letters only"); 
jQuery.validator.addMethod("projname", function(value, element) {
  return this.optional(element) || /^[a-zA-Z]+(([a-zA-Z0-9]*[ ]?[a-zA-Z0-9]+)?)*$/i.test(value);
}, "Not a valid project name."); $( document ).ready(function() {
 $('form').validate({
        rules: {
        	userName:{
        		required: true
        	},
        	password:{
        		required: true
        	},
        	project: {
                required: true
            },
            severity: {
                required: true
            },
            issueForProject: {
                minlength: 3,
                maxlength: 100,
				projname: true,
                required: true
            },
            contactName: {
                minlength: 3,
                maxlength: 30,
				lettersonly: true,
                required: true
            },
            contactEmail: {
                required: true,
				dell: true

            },
            contactNumber: {
				exactlength: 10,
				number: true,
                required: true

            },
            description: {
                minlength: 10,
                maxlength: 1500,
                required: true
            }
        },
        highlight: function(element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
        errorClass: 'help-block',
        errorPlacement: function(error, element) {
            if(element.parent('.input-group').length) {
                error.insertAfter(element);
            } else {
                error.insertAfter(element);
            }
        }

    });
});