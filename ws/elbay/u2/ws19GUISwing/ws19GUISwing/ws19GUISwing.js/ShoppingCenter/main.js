document.addEventListener("DOMContentLoaded", () => {
    const txtId = document.getElementById("txtId");
    const txtFirstName = document.getElementById("txtFirstName");
    const txtLastName = document.getElementById("txtLastName");
    const txtMoneySpent = document.getElementById("txtMoneySpent");
    const sldAge = document.getElementById("sldAge");
    const lblAge = document.getElementById("lblAge");
    const cmbGender = document.getElementById("cmbGender");
    const cmbTypeOfCustomer = document.getElementById("cmbTypeOfCustomer");
    const lstHobbies = document.getElementById("lstHobbies");

    txtId.addEventListener("input", (e) => {
        e.target.value = e.target.value.replace(/[^0-9]/g, "");
    });

    const alphaRegex = /[^a-zA-Z\s]/g;
    txtFirstName.addEventListener("input", (e) => {
        e.target.value = e.target.value.replace(alphaRegex, "");
    });
    txtLastName.addEventListener("input", (e) => {
        e.target.value = e.target.value.replace(alphaRegex, "");
    });

    txtMoneySpent.addEventListener("input", (e) => {
        let val = e.target.value;
        val = val.replace(/[^0-9.]/g, "");
        const parts = val.split(".");
        if (parts.length > 2) {
            val = parts[0] + "." + parts.slice(1).join("");
        }
        e.target.value = val;
    });

    document.getElementById("btnInsert").addEventListener("click", () => {
        if (!txtId.value || !txtFirstName.value || !txtLastName.value || !txtMoneySpent.value) {
            alert("All fields must be filled");
            return;
        }

        const selectedHobbies = Array.from(lstHobbies.selectedOptions).map(option => option.value);

        const customer = new Customer(
            parseInt(txtId.value),
            txtFirstName.value,
            txtLastName.value,
            cmbGender.value,
            parseFloat(txtMoneySpent.value),
            parseInt(sldAge.value),
            cmbTypeOfCustomer.value,
            selectedHobbies
        );

        console.log(customer.toString());
        alert("Customer data captured successfully!\nCheck the browser developer console (F12).");
    });

    document.getElementById("btnCancel").addEventListener("click", () => {
        txtId.value = "";
        txtFirstName.value = "";
        txtLastName.value = "";
        txtMoneySpent.value = "";
        sldAge.value = 0;
        lblAge.innerText = "0";
        cmbGender.selectedIndex = 0;
        cmbTypeOfCustomer.selectedIndex = 0;
        lstHobbies.selectedIndex = -1;
    });

    document.getElementById("btnQuit").addEventListener("click", () => {
        window.close();
    });
});

