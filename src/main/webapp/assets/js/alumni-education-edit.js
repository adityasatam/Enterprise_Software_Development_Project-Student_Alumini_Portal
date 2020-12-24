let alumni_education_add = document.getElementById('add_education');
window.onload = fetch_education;

alumni_education_add.addEventListener('click', async (e) => {
    location.href = "addneweducation.html";
});

async function fetch_education(){
    let response = await fetch("api/alumni/geteducation");
    console.log("hi:");
    let alumniEducation = await response.json(); // read response body and parse as JSON
    console.log(alumniEducation);
    document.getElementById("first_name").value = alumniEducation[1];
    document.getElementById("last_name").value = alumniEducation[2];
    let alumni_education = document.getElementById('alumni_education');
    for(let i=0;i<(alumniEducation.length - 3)/6;i++){
        alumni_education.innerHTML += '<div class="row">\n' +
            '                <div class="col-md-6 mb-3">\n' +
            '                    <label for="degree">Degree</label>\n' +
            '                    <input class="form-control" id="degree" disabled placeholder="" required type="text" value="'+alumniEducation[(i*6)+3]+'">\n' +
            '                    <div class="invalid-feedback">\n' +
            '                        Please enter a valid Degree Name.\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '                <div class="col-md-6 mb-3">\n' +
            '                    <label for="collegeName">College Name</label>\n' +
            '                    <input class="form-control" id="collegeName" disabled placeholder="" required type="text" value="'+alumniEducation[(i*6)+4]+'">\n' +
            '                    <div class="invalid-feedback">\n' +
            '                        Please enter valid College Name.\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="row">\n' +
            '                <div class="col-md-6 mb-3">\n' +
            '                    <label for="joiningYear">Joining Year</label>\n' +
            '                    <input class="form-control" id="joiningYear" disabled placeholder="" required type="text" value="'+alumniEducation[(i*6)+5]+'">\n' +
            '                    <div class="invalid-feedback">\n' +
            '                        Please enter a Joining Year.\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '                <div class="col-md-6 mb-3">\n' +
            '                    <label for="passingYear">Passing Year</label>\n' +
            '                    <input class="form-control" id="passingYear" disabled placeholder="" required type="text" value="'+alumniEducation[(i*6)+6]+'">\n' +
            '                    <div class="invalid-feedback">\n' +
            '                        Please enter valid Passing Year.\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="row  mb-3">\n' +
            '                <div class="col-md-6 mb-3">\n' +
                '                <label for="address">Address</label>\n' +
                '                <input class="form-control" id="address" disabled placeholder="" required type="text" value="'+alumniEducation[(i*6)+7]+'">\n' +
                '                <div class="invalid-feedback">\n' +
                '                    Please enter a Address.\n' +
                '                </div>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <hr class="mb-4">\n' +
            '            <div class="row">\n' +
            '                <div class="col-md-6 mb-3">\n' +
            '                    <button class="btn btn-primary btn-lg btn-block" id="'+alumniEducation[(i*6)+8]+'" type="button">Edit / Delete</button>\n' +
            '                </div>\n' +
            '            </div>' +
            '            <br />'
    }

    let li = document.getElementsByTagName("button");
    for(let i = 0;i<i<(alumniEducation.length - 3)/6;i++){
        li[i].addEventListener("click", myScript);
    }
    function myScript(e){
        // alert(e.target.attributes.id.value);
        sessionStorage.setItem("alumniEducationId", e.target.attributes.id.value);
        location.href = "educationeditdelete.html";
    }
}

// function getEventTarget(e) {
//     e = e || window.event;
//     return e.target || e.srcElement;
// }
//
// const ul = document.getElementById('alumni_education');
// ul.onclick = function(event) {
//     var target = getEventTarget(event);
//     alert(target.innerHTML);
// };

