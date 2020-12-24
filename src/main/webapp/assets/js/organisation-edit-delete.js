let delete_organisation = document.getElementById("delete_organisation");
let update_organisation = document.getElementById("update_organisation");
window.onload = fetch_organisation_by_id;

update_organisation.addEventListener("click", async (e) => {
    console.log("Hi, alumni details view");
    e.preventDefault();
    e.stopPropagation();
    let alumniOrganisationid = sessionStorage.getItem("alumniOrganisationId");
    console.log(alumniOrganisationid);
    if (update_organisation.checkValidity() === true) {
        let response = await fetch('api/org/updateOrganisation', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                alumniOrganisationId: sessionStorage.getItem("alumniOrganisationId"),
                alumni_org_name: document.getElementById('alumni_org_name').value,
                alumni_org_position: document.getElementById('alumni_org_position').value,
                alumni_org_joining_date: document.getElementById('alumni_org_joining_date').value,
                alumni_org_leaving_date: document.getElementById('alumni_org_leaving_date').value
            })
        });
        let result = await response;
        console.log(result);
    }
    update_organisation.classList.add('was-validated');
    location.href = "alumniorganisationedit.html";
});

delete_organisation.addEventListener("click", async (e) => {
    console.log("Hi, alumni details view");
    e.preventDefault();
    e.stopPropagation();
    let alumniOrganisationid = sessionStorage.getItem("alumniOrganisationId");
    console.log(alumniOrganisationid);
    if (delete_organisation.checkValidity() === true) {
        let response = await fetch('api/org/deleteOrganisation', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                alumniOrganisationId: sessionStorage.getItem("alumniOrganisationId"),
                alumni_org_name: document.getElementById('alumni_org_name').value,
                alumni_org_position: document.getElementById('alumni_org_position').value,
                alumni_org_joining_date: document.getElementById('alumni_org_joining_date').value,
                alumni_org_leaving_date: document.getElementById('alumni_org_leaving_date').value
            })
        });
        let result = await response;
        console.log(result);
    }
    delete_organisation.classList.add('was-validated');
    location.href = "alumniorganisationedit.html";
});

async function fetch_organisation_by_id(){
    console.log(sessionStorage.getItem("alumniOrganisationId"));
    let response = await fetch("api/org/getOrganisationById", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            t: sessionStorage.getItem("alumniOrganisationId"),
        })
    });
    console.log("hi:");
    let organisationDetails = await response.json(); // read response body and parse as JSON
    console.log(organisationDetails);
    document.getElementById("alumni_org_name").value = organisationDetails[0];
    document.getElementById("alumni_org_position").value = organisationDetails[1];
    document.getElementById("alumni_org_joining_date").value = organisationDetails[2];
    document.getElementById("alumni_org_leaving_date").value = organisationDetails[3];
}