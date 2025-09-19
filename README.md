
# mediLaboDiabetes

Easily track and predict Type-2 diabetes in your patients with mediLaboDiabetes!




## Authors

- [@apurple_dv](https://github.com/apurpledv)


## Features

- View/add/edit any patient's data
- View/add/edit previous doctor notes following a consultation about a given patient
- Automated risk assessment depending on the contents of a patient's notes of them developing Type-2 diabetes


## Tech Stack

**Client:** HTML5/CSS

**Server:** Java (Spring Boot)

**Misc:** Docker


## Optimizations - Green Code

To better contend with Green Code guidelines, here are some possible improvements to be made to this project:

- Optimise the way data is loaded and displayed (instead of every patient/note being loaded at once, only fetch 20-30 per "page")

- Find a way to limit storage usage using caching technologies

- Ligthen the resources used (lightweight image formats, use libraries to minify JavaScript/JSON files...)

- Use a Cloud-hosted Database (like Atlas for MongoDB, instead of having an instance run on the server)

- Use retroactive and user device-friendly libraries, functions and modules
