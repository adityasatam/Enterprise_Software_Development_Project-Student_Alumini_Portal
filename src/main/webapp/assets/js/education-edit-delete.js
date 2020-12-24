let delete_education = document.getElementById("delete_education");
let update_education = document.getElementById("update_education");
window.onload = fetch_education_by_id;

update_education.addEventListener("click", async (e) => {
    console.log("Hi, alumni details view");
    e.preventDefault();
    e.stopPropagation();
    let alumniEducationid = sessionStorage.getItem("alumniEducationId");
    console.log(alumniEducationid);
    if (update_education.checkValidity() === true) {
        let response = await fetch('api/alumni/updateEducation', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                alumniEducationId: sessionStorage.getItem("alumniEducationId"),
                degree: document.getElementById('degree').value,
                passingYear: document.getElementById('passingYear').value,
                joiningYear: document.getElementById('joiningYear').value,
                collegeName: document.getElementById('collegeName').value,
                address: document.getElementById('address').value
            })
        });
        let result = await response;
        console.log(result);
    }
    update_education.classList.add('was-validated');
    location.href = "alumnieducationedit.html";
});

delete_education.addEventListener("click", async (e) => {
    console.log("Hi, alumni details view");
    e.preventDefault();
    e.stopPropagation();
    let alumniEducationid = sessionStorage.getItem("alumniEducationId");
    console.log(alumniEducationid);
    if (delete_education.checkValidity() === true) {
        let response = await fetch('api/alumni/deleteEducation', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                alumniEducationId: sessionStorage.getItem("alumniEducationId"),
                degree: document.getElementById('degree').value,
                passingYear: document.getElementById('passingYear').value,
                joiningYear: document.getElementById('joiningYear').value,
                collegeName: document.getElementById('collegeName').value,
                address: document.getElementById('address').value
            })
        });
        let result = await response;
        console.log(result);
    }
    delete_education.classList.add('was-validated');
    location.href = "alumnieducationedit.html";
});

async function fetch_education_by_id(){
    console.log(sessionStorage.getItem("alumniEducationId"));
    let response = await fetch("api/alumni/getEducationById", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            t: sessionStorage.getItem("alumniEducationId"),
        })
    });
    console.log("hi:");
    let educationDetails = await response.json(); // read response body and parse as JSON
    console.log(educationDetails);
    document.getElementById("degree").value = educationDetails[0];
    document.getElementById("collegeName").value = educationDetails[1];
    document.getElementById("joiningYear").value = educationDetails[2];
    document.getElementById("passingYear").value = educationDetails[3];
    document.getElementById("address").value = educationDetails[4];
}