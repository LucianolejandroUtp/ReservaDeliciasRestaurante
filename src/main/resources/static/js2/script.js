
const requestButton = document.getElementById('request-button');
const waitingModal = document.getElementById('waiting-modal');
const responseModal = document.getElementById('response-modal');
const responseMessage = document.getElementById('response-message');
const fileUploadContainer = document.getElementById('file-upload-container');
const fileUpload = document.getElementById('file-upload');
const uploadButton = document.getElementById('upload-button');
const confirmButton = document.getElementById('confirm-button');
const cancelButton = document.getElementById('cancel-button');

requestButton.addEventListener('click', () => {
    waitingModal.style.display = 'block';

    
        const formData = new FormData();
        formData.append('name', document.getElementById('name').value);
        formData.append('phone', document.getElementById('phone').value);
        formData.append('date', document.getElementById('date').value);
        formData.append('email', document.getElementById('email').value);
        formData.append('number', document.getElementById('number').value);
        formData.append('time', document.getElementById('time').value);

        
        const response = {
            status: 'success', // or 'error'
            message: 'Mesa disponible' // or 'Mesa no disponible'
        };

       
        if (response.status === 'success') {
           responseModal.style.display = 'block';
            responseMessage.textContent = response.message;
            fileUploadContainer.style.display = 'block';
        } else {
           responseModal.style.display = 'block';
            responseMessage.textContent = response.message;
            fileUploadContainer.style.display = 'none';
        }

        waitingModal.style.display = 'none';
    }, 2000);

uploadButton.addEventListener('click', () => {
    const file = fileUpload.files[0];

     console.log('File uploaded:', file);


    confirmButton.style.display = 'block';
});

confirmButton.addEventListener('click', () => {
    console.log('Reservación confirmada');

    responseModal.style.display = 'none';
});

cancelButton.addEventListener('click', () => {
   
    console.log('Reservacion Cancelada');

    responseModal.style.display = 'none';
});