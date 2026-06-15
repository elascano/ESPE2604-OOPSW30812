async function saveVehicle() {

    try {

        const vehicle = {

            id:
            document.getElementById("id").value,

            description:
            document.getElementById("description").value,

            value:
            Number(
                document.getElementById("value").value
            ),

            quantity:
            Number(
                document.getElementById("quantity").value
            )
        };

        const response =
            await fetch(
                "http://localhost:3000/vehicles",
                {
                    method: "POST",
                    headers: {
                        "Content-Type":
                        "application/json"
                    },
                    body:
                    JSON.stringify(vehicle)
                }
            );

        if (!response.ok) {

            throw new Error(
                "Error saving vehicle"
            );
        }

        await loadVehicles();

        document.getElementById("id").value = "";
        document.getElementById("description").value = "";
        document.getElementById("value").value = "";
        document.getElementById("quantity").value = "";

    } catch(error) {

        console.error(error);

        alert(
            "Error: " + error.message
        );
    }
}

async function loadVehicles() {

    try {

        const response =
            await fetch(
                "http://localhost:3000/vehicles"
            );

        const vehicles =
            await response.json();

        let html = "";

        vehicles.forEach(vehicle => {

            html += `
            <tr>
                <td>${vehicle.id}</td>
                <td>${vehicle.description}</td>
                <td>${vehicle.value}</td>
                <td>${vehicle.quantity}</td>
                <td>${vehicle.value * vehicle.quantity}</td>
            </tr>
            `;
        });

        document
            .getElementById(
                "vehicleTable"
            )
            .innerHTML = html;

    } catch(error) {

        console.error(error);
    }
}

window.onload = function() {
    loadVehicles();
};