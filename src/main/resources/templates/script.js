fetch('/students')
  .then(response => response.json())
  .then(data => {
    const studentsList = document.getElementById('students-list');
    data.forEach(student => {
      const listItem = document.createElement('li');
      listItem.textContent = student.name;
      studentsList.appendChild(listItem);
    });
  });