const apiBase = "/api";

const tabs = document.querySelectorAll(".tabs button");
const panels = document.querySelectorAll(".tab-panel");
const customerForm = document.getElementById("customer-form");
const productForm = document.getElementById("product-form");
const supplierForm = document.getElementById("supplier-form");
const infoSelect = document.getElementById("info-select");
const loadInfoButton = document.getElementById("load-info");
const infoTable = document.getElementById("info-table");

function switchTab(tabName) {
  tabs.forEach((button) => {
    button.classList.toggle("active", button.dataset.tab === tabName);
  });
  panels.forEach((panel) => {
    panel.classList.toggle("active", panel.id === tabName);
  });
}

tabs.forEach((button) => {
  button.addEventListener("click", () => switchTab(button.dataset.tab));
});

function showNotification(message, type = "success") {
  const notification = document.createElement("div");
  notification.className = `notification notification-${type}`;
  notification.textContent = message;
  document.body.appendChild(notification);

  setTimeout(() => {
    notification.classList.add("show");
  }, 100);

  setTimeout(() => {
    notification.classList.remove("show");
    setTimeout(() => notification.remove(), 300);
  }, 3000);
}

async function postJson(url, data) {
  const response = await fetch(url, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });
  
  const text = await response.text();
  console.log("Response status:", response.status);
  console.log("Response text:", text);
  
  if (!response.ok) {
    try {
      const errorData = JSON.parse(text);
      throw new Error(errorData.error || "Failed to insert data");
    } catch (e) {
      throw new Error(`Server error: ${text || "Empty response"}`);
    }
  }
  
  try {
    return JSON.parse(text);
  } catch (e) {
    throw new Error("Invalid JSON response from server");
  }
}

async function loadInfo() {
  const collection = infoSelect.value;
  const response = await fetch(`${apiBase}/${collection}`);
  const data = await response.json();
  renderTable(collection, data);
}

function renderTable(collection, rows) {
  const columns = {
    customers: ["ruc", "name", "address", "gmailCustomer"],
    products: ["id", "name", "unitPrice", "stock"],
    suppliers: ["ruc", "companyName", "address", "phone", "email"],
  };

  const columnLabels = {
    customers: ["RUC", "Name", "Address", "Gmail"],
    products: ["ID", "Name", "Unit Price", "Stock"],
    suppliers: ["RUC", "Company", "Address", "Phone", "Email"],
  };

  const selectedColumns = columns[collection];
  const labels = columnLabels[collection];

  infoTable.tHead.innerHTML = "";
  infoTable.tBodies[0].innerHTML = "";

  const headerRow = document.createElement("tr");
  labels.forEach((label) => {
    const th = document.createElement("th");
    th.textContent = label;
    headerRow.appendChild(th);
  });
  infoTable.tHead.appendChild(headerRow);

  const body = infoTable.tBodies[0];
  if (rows.length === 0) {
    const tr = document.createElement("tr");
    const td = document.createElement("td");
    td.colSpan = labels.length;
    td.textContent = "No data found";
    td.style.textAlign = "center";
    tr.appendChild(td);
    body.appendChild(tr);
  } else {
    rows.forEach((row) => {
      const tr = document.createElement("tr");
      selectedColumns.forEach((column) => {
        const td = document.createElement("td");
        td.textContent = row[column] ?? "";
        tr.appendChild(td);
      });
      body.appendChild(tr);
    });
  }
}

function handleFormSubmit(form, url, formName) {
  form.addEventListener("submit", async (event) => {
    event.preventDefault();

    try {
      const formData = new FormData(form);
      const data = Object.fromEntries(formData.entries());
      
      console.log("Submitting data:", data);
      
      await postJson(url, data);
      form.reset();
      showNotification(`${formName} inserted successfully!`, "success");
      loadInfo();
    } catch (error) {
      showNotification(`Error: ${error.message}`, "error");
    }
  });
}

handleFormSubmit(customerForm, `${apiBase}/customers`, "Customer");
handleFormSubmit(productForm, `${apiBase}/products`, "Product");
handleFormSubmit(supplierForm, `${apiBase}/suppliers`, "Supplier");
loadInfoButton.addEventListener("click", loadInfo);

switchTab("customer");
loadInfo();
