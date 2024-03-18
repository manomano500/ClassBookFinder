
//function loadContent(url, frameId) {
//    var frame = document.getElementById(frameId);
//    frame.src = url;
////                return false;
//
//
//
//}
//function loadDepartmentPage(event) {
//    if (event.status === 'success') {
//        var departmentName = event.source.value;
//        var iframe = document.getElementById('subject-details');
//        iframe.src = 'department.xhtml?dept=' + departmentName;
////            alert("Loading department page for: " + departmentName);
//    }
//}

function reloadIframeOnSuccess(data) {
    if (data.status === 'success') {
        reloadDepartmentIframe();
        reloadSubjectsIframe;
    }
}
function reloadDepartmentIframe() {
    var iframe = document.getElementById('department-details');
    iframe.src = iframe.src; // This will reload the iframe


}
function reloadSubjectsIframe() {
    var iframe = document.getElementById('subject-details');
    iframe.src = iframe.src; // This will reload the iframe


}
function loadMain(page) {
    var include = document.getElementsByClassName("main-include");
    include.src = page;

}





// Get all dropdown buttons
var dropdowns = document.getElementsByClassName("dropbtn");

// Add click event listener to each dropdown button
for (var i = 0; i < dropdowns.length; i++) {
    dropdowns[i].addEventListener("click", function () {
        var dropdownContent = this.nextElementSibling;
        if (dropdownContent.style.display === "block") {
            dropdownContent.style.display = "none";
        } else {
            dropdownContent.style.display = "block";
        }
    });
}

function loadDepartmentPage() {
    // Update the sidebar title with the selected department name
    var sidebarTitle = document.getElementById("sidebarTitle");
    var selectedDepartment = document.getElementById("selectedDepartment");
    sidebarTitle.innerText = selectedDepartment.value;
}

function toggleSemesters() {
    var semestersDiv = document.getElementById("semesters");
    if (semestersDiv.style.display === "none") {
        semestersDiv.style.display = "block";
    } else {
        semestersDiv.style.display = "none";
    }
}
function toggleDepartments() {
    var departmentsDiv = document.getElementById("departments");
    if (departmentsDiv.style.display === "none") {
        departmentsDiv.style.display = "block";
    } else {
        departmentsDiv.style.display = "none";
    }
}