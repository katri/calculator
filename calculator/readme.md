## Calculation app
This is a small application to save 2 numbers and their sum.
The application uses a List to store Number Objects. List is emptied each time application is restarted.

Application works on localhost, port 8080:
`localhost:8080/`

Application currently provides 2 REST services:
1. GET service to add a NumberObject with 2 integers to the list. On saving 2 integres, also their sum is saved as 3rd integer.
2. GET service to retrieve from the list objects that contain desired integer.
- List sorting can be chosen as ascending or descending
- If integer parameter is left empty, the request wil return full list of all NumberObjects
