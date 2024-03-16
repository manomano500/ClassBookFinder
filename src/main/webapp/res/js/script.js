
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