document.addEventListener('DOMContentLoaded', function(event) {
    const button = document.getElementById("update-button");
    const select_elements = document.getElementsByTagName("select");
    
    for (let e of select_elements) {
        // Set name to empty string so by default, it doesn't get sent with the form submit
        e.name = "";

        // Register onchange event for every select element
        e.onchange = () => { 
            button.disabled = false;

            // Change the name of each select element to include the user id it represents, but only when its value gets changed
            let id = e.parentElement;
            while (id.id != "id-text") {
                id = id.previousElementSibling;
            }

            e.name = "user-id-" + id.textContent;
        };
    };
  })
