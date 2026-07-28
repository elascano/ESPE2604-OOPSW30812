async function sortArray() {


    const input = document.getElementById("arrayInput").value;


    const array = input
        .split(",")
        .map(Number);


    const response = await fetch("/sort", {

        method: "POST",

        headers: {

            "Content-Type": "application/json"

        },

        body: JSON.stringify({

            array: array

        })

    });


    const data = await response.json();



    const table = document.getElementById("result");



    table.innerHTML = `

        <tr>

            <td>${data.original}</td>

            <td>${data.size}</td>

            <td>${data.algorithm}</td>

            <td>${data.result}</td>

        </tr>

    `;


}