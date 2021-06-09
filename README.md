![Charaka Logo](logo.png)
# A social media for booklovers
Charaka is a mobile-first social media platform for booklovers. To do that, Charaka embeds a machine learning model within the platform as an Android app so book
lovers get book recommendations and engage with other booklovers right from the fingertips.

## Datasets

## Tech stacks
Charaka was built from 4 different parts:
* Android app for users
* Book Catalogue and User Database on Firebase Firestore 
* Book Recommender deployed on Google Cloud Functions
* Machine learning recommender algorithm using Tensorflow

## How to use it?
When the user uses for the first time, the user has to sign up with Google account. The user will logged in to the app and get some books recommended by the app. The user can see the details of the book. When the user has finished a book, the user can make a post to share what the user read on the app.

## How does it work?
The app generates a book recommendation for users by invoking the recommender model in Google Cloud Functions. The data of the book itself is pulled from the book database in Firebase Firestore. User data including user reviews are also stored in Firebase Firestore.

## How to deploy/develop it?
* [Back-end](https://github.com/nurrizkyimani/bangkit-api-backend)
* [Machine Learning](https://github.com/Barragan17/Charaka/tree/master/Colab)

## The Team
* Azhara Fathin (ML Developer)
* Linus Randu D (ML Developer)
* Tegar Taufik R (Android Developer)
* Vina Maulida (Android Developer)
* Alexius Adhitya K (Cloud Engineer)
* Nurrizky Imani (Cloud Engineer)
