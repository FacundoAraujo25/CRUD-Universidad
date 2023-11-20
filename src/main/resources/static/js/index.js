function fetchApiData() {
    const urls = [
        '/api/courses',
        '/api/teachers',
        '/api/students'
    ];

    const requests = urls.map(url => axios.get(url));

    Promise.all(requests)
        .then(responses => {
            const courses = responses[0].data;
            const teachers = responses[1].data;
            const students = responses[2].data;

            console.log('Courses:', courses);
            console.log('Teachers:', teachers);
            console.log('Students:', students);

            document.getElementById('coursesCount').innerText = courses.length;
            document.getElementById('teachersCount').innerText = teachers.length;
            document.getElementById('studentsCount').innerText = students.length;

        })
        .catch(error => {
            // Manejo de errores
            console.error('Error fetching data:', error);
        });
}

function fillTeachersTable(teachers) {
    const tableBody = document.getElementById('generalTable').getElementsByTagName('tbody')[0];
    tableBody.innerHTML = ''; // Limpiar la tabla

    teachers.forEach(teacher => {
        let row = tableBody.insertRow();
        let nameCell = row.insertCell(0);
        nameCell.innerText = teacher.name;

        let detailsCell = row.insertCell(1);
        detailsCell.innerText = teacher.details;
        // Agregar más celdas según tus datos
    });
}

fetchApiData();
