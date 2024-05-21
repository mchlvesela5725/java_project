document.addEventListener('DOMContentLoaded', function() {
    fetchProjects();
});

async function fetchProjects() {
    try {
        const response = await fetch('http://localhost:8080/api/projects');
        const projects = await response.json();
        displayProjects(projects);
    } catch (error) {
        console.error('Error fetching projects:', error);
    }
}

async function fetchUsers() {
    try {
        const response = await fetch('http://localhost:8080/api/users');
        const users = await response.json();
        return users;
    } catch (error) {
        console.error('Error fetching users:', error);
        return [];
    }
}

async function createProject(newProject) {
    try {
        const response = await fetch('http://localhost:8080/api/projects', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(newProject),
        });
        const createdProject = await response.json();
        return createdProject;
    } catch (error) {
        console.error('Error creating project:', error);
        return null;
    }
}

async function updateProject(id, updatedProject) {
    try {
        const response = await fetch(`http://localhost:8080/api/projects/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(updatedProject),
        });
        const updatedProjectData = await response.json();
        return updatedProjectData;
    } catch (error) {
        console.error('Error updating project:', error);
        return null;
    }
}

async function deleteProject(id) {
    try {
        const response = await fetch(`http://localhost:8080/api/projects/${id}`, {
            method: 'DELETE',
        });
        if (response.status === 204) {
            return true; // Deleted successfully
        } else {
            console.error('Error deleting project:', response.statusText);
            return false;
        }
    } catch (error) {
        console.error('Error deleting project:', error);
        return false;
    }
}

function displayProjects(projects) {
    const projectsList = document.getElementById('projectsList');
    projectsList.innerHTML = '';

    projects.forEach(function(project) {
        const card = document.createElement('div');
        card.classList.add('card', 'project-card', 'col-md-4');

        const cardBody = document.createElement('div');
        cardBody.classList.add('card-body');

        const title = document.createElement('h5');
        title.classList.add('card-title');
        title.textContent = project.name;
        cardBody.appendChild(title);

        const description = document.createElement('p');
        description.classList.add('card-text');
        description.textContent = project.description;
        cardBody.appendChild(description);

        const date = document.createElement('p');
        date.classList.add('card-text');
        date.textContent = 'Date: ' + project.date;
        cardBody.appendChild(date);

        const condition = document.createElement('p');
        condition.classList.add('card-text');
        condition.textContent = 'Condition: ' + getConditionText(project.condition);
        cardBody.appendChild(condition);

        const user = document.createElement('p');
        user.classList.add('card-text');
        user.textContent = 'User: ' + project.user.user_name;
        cardBody.appendChild(user);

        const editButton = document.createElement('button');
        editButton.classList.add('btn', 'btn-primary', 'mr-2');
        editButton.textContent = 'Edit';
        editButton.dataset.toggle = 'modal';
        editButton.dataset.target = '#editProjectModal';
        editButton.addEventListener('click', function() {
            populateEditProjectModal(project);
        });
        cardBody.appendChild(editButton);

        const deleteButton = document.createElement('button');
        deleteButton.classList.add('btn', 'btn-danger');
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', function() {
            deleteProject(project.id).then(function(deleted) {
                if (deleted) {
                    fetchProjects();
                }
            });
        });
        cardBody.appendChild(deleteButton);

        card.appendChild(cardBody);
        projectsList.appendChild(card);
    });
}

function populateEditProjectModal(project) {
    document.getElementById('editId').value = project.id;
    document.getElementById('editName').value = project.name;
    document.getElementById('editDescription').value = project.description;
    document.getElementById('editDate').value = project.date;
    document.getElementById('editCondition').value = project.condition;
    document.getElementById('editUser').value = project.user.id;
}

document.getElementById('addProjectButton').addEventListener('click', function() {
    resetForm();
    populateUserOptions('user');
});

document.getElementById('saveProject').addEventListener('click', function() {
    const name = document.getElementById('name').value;
    const description = document.getElementById('description').value;
    const date = document.getElementById('date').value;
    const condition = document.getElementById('condition').value;
    const userId = document.getElementById('user').value;

    const newProject = {
        name: name,
        description: description,
        date: date,
        condition: condition,
        id_user: userId
    };

    createProject(newProject).then(function(createdProject) {
        if (createdProject) {
            $('#projectModal').modal('hide');
            fetchProjects();
        }
    });
});

document.getElementById('updateProjectButton').addEventListener('click', function() {
    const id = document.getElementById('editId').value;
    const name = document.getElementById('editName').value;
    const description = document.getElementById('editDescription').value;
    const date = document.getElementById('editDate').value;
    const condition = document.getElementById('editCondition').value;
    const userId = document.getElementById('editUser').value;

    const updatedProject = {
        name: name,
        description: description,
        date: date,
        condition: condition,
        id_user: userId
    };

    updateProject(id, updatedProject).then(function(updatedProjectData) {
        if (updatedProjectData) {
            $('#editProjectModal').modal('hide');
            fetchProjects();
        }
    });
});

function resetForm() {
    document.getElementById('name').value = '';
    document.getElementById('description').value = '';
    document.getElementById('date').value = '';
    document.getElementById('condition').value = '';
    document.getElementById('user').value = '';
}

function populateUserOptions(elementId) {
    fetchUsers().then(function(users) {
        const userSelect = document.getElementById(elementId);
        userSelect.innerHTML = '<option value="">Choose author</option>';
        users.forEach(function(user) {
            const option = document.createElement('option');
            option.value = user.id;
            option.textContent = user.user_name;
            userSelect.appendChild(option);
        });
    });
}

function getConditionText(condition) {
    switch (condition) {
        case 'I':
            return 'In Progress';
        case 'E':
            return 'Empty';
        case 'F':
            return 'Finished';
        default:
            return condition;
    }
}

