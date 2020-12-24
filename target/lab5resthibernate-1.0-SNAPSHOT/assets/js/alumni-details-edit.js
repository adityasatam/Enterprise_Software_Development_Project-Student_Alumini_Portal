let student_details_update = document.getElementById('student-details-update');
window.onload = fetch_courses;

student_details_update.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (student_details_update.checkValidity() === true) {
        let response = await fetch('api/students/detailsupdate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                first_name: document.getElementById('first_name').value,
                last_name: document.getElementById('last_name').value,
                roll_number: document.getElementById('roll_number').value,
                email: document.getElementById('email').value,
                cgpa: document.getElementById('cgpa').value,
                total_credits: document.getElementById('total_credits').value,
                graduation_year: document.getElementById('graduation_year').value,
            })
        });
        let result = await response;
        console.log(result);
    }
    student_details_update.classList.add('was-validated');
});

async function fetch_courses(){
    let response = await fetch("api/students/getdetails");
    console.log("hi:");
    let student = await response.json(); // read response body and parse as JSON
    console.log(student);
    document.getElementById("first_name").value = student[0];
    document.getElementById("last_name").value = student[1];
    document.getElementById("roll_number").value = student[2];
    document.getElementById("graduation_year").value = student[3];
    document.getElementById("cgpa").value = student[4];
    document.getElementById("total_credits").value = student[5];
    document.getElementById("email").value = student[6];
}