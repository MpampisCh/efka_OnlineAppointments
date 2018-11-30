$(document).ready(function () {
 inputValidation();
})
$(document).on('shown.bs.modal', function () {
 inputValidation();
})

function inputValidation() {

    $("form:not([data-custom-validation]) input,textarea,select").on("keyup change blur", function () {
        try {
            const closestForm = $(this).closest("form");
            if (!closestForm.length) {
                console.warn("Submit button is undefined.");
                return;
            }

            // Enable / Disable submit button
            let submitButton = $(closestForm).find("[type='button'],button");
            if (submitButton.length > 1) {
                  submitButton.splice(0, 1);
            }
           if (!submitButton.length) {
                console.warn("Submit button is undefined.");
                return;
            }

            const isFormValid = $(closestForm)[0].checkValidity();


            submitButton.attr("disabled", !isFormValid);


            const isCurrentTargetValid = $(this).is(":valid");
            if (!isCurrentTargetValid) {
              let thisAlert = $(this).parent();
              $(thisAlert).addClass('alert-validate');
            } else {
                let thisAlert =  $(this).parent();
               $(thisAlert).removeClass('alert-validate');
            }
        }catch(e) {
            console.error(e);
        }
    });

}

    /*
   $(document).ready(function () {


       $("form:not([data-enable-validation]) input").on("keyup change focus", function () {
           try {
               const closestForm = $(this).closest("form");
               if (!closestForm.length) {
                   console.warn("Submit button is undefined.");
                   return;
               }

               // Enable / Disable submit button
               const submitButton = $(closestForm).find("[type='button'],button");
               if (!submitButton.length) {
                   console.warn("Submit button is undefined.");
                   return;
               }

               const isFormValid = $(closestForm)[0].checkValidity();

               submitButton.attr("disabled", !isFormValid);

               // Show / Hide error label
               const errorLabel = $(this).closest(".field").find(".error-label");
               if (!errorLabel.length) {
                   console.warn("Error label is undefined.");
                   return;
               }

               const isCurrentTargetValid = $(this).is(":valid");
               if (!isCurrentTargetValid) {
                   $(errorLabel).show();
               } else {
                   $(errorLabel).hide();
               }
           }catch(e) {
               console.error(e);
           }
       });
   //custom validations
       $("form[data-enable-validation] input[data-validation][data-validation!='submit']").on("keyup change focus", function () {
           try {
               const value = $(this).val() || "";
               const validation_type = $(this).attr("data-validation");

               switch (validation_type) {
                   case "no_numbers":
                       validate(this, value, /^[^0-9]+$/);
                       break;
                   default:
                       console.warn("Wrong validation name.", validation_type);
                       break;
               }

           } catch (e) {
               console.error(e);
           }
       });


       function validate(element, value, regex) {

           // Test element value
           const isValid = regex.test(value);

           if (!isValid) {
               if ($(element).hasClass("valid-data")) {
                   $(element).removeClass("valid-data");
               }

               if (!$(element).hasClass("invalid-data")) {
                   $(element).addClass("invalid-data");
               }

           }
           else {
               if ($(element).hasClass("invalid-data")) {
                   $(element).removeClass("invalid-data");
               }

               if (!$(element).hasClass("valid-data")) {
                   $(element).addClass("valid-data");
               }

           }

           changeSubmitButtonStatus(element);
       }

       function changeSubmitButtonStatus(element) {
           // Disable/ enable button

           const closestForm = $(element).closest("form");
           if (!closestForm.length) {
               console.warn("Submit button is undefined.");
               return;
           }

           const submitButton = $(closestForm).find("[data-validation='submit']");
           if (!submitButton.length) {
               console.warn("Submit button is undefined.");
               return;
           }

           const allElements = $(closestForm).find("[data-validation][data-validation!='submit']").length;
           const validElements = $(closestForm).find(".valid-data").length;

           submitButton.attr("disabled", allElements !== validElements);
       }
   })*/