(ns firebase-cljs.auth.provider
  (:require [cljsjs.firebase]))

(defn email
  "Returns a new email and password auth provider implementation."
  []
  (new js/firebase.auth.EmailAuthProvider))

(defn facebook
  "Returns a new facebook auth provider."
  []
  (new js/firebase.auth.FacebookAuthProvider))

(defn github
  "Returns a new github auth provider."
  []
  (new js/firebase.auth.GithubAuthProvider))

(defn google
  "Returns a new google auth provider."
  []
  (new js/firebase.auth.GoogleAuthProvider))

(defn twitter
  "Returns a new twitter auth provider."
  []
  (new js/firebase.auth.TwitterAuthProvider))

(defn scope
  "Add scope to auth provider. Takes a `provider` and `scope`."
  [provider scope]
  (.. provider (addScope scope)))

(defn scope-email
  "Add email scope to an auth provider. Takes an `auth` Firebase Auth service
  and a keywordized `provider`."
  [auth provider]
  (case provider
    :google (scope auth "https://www.googleapis.com/auth/userinfo.email")
    :facebook (scope auth "email")
    :github (scope auth "user:email")))

(defn scope-profile
  "Add profile scope to an auth provider. Takes an `auth` Firebase Auth service
  and a keywordized `provider`."
  [auth provider]
  (case provider
    :google (scope auth "https://www.googleapis.com/auth/userinfo.profile")
    :facebook (scope auth "public_profile")
    :github (scope auth "")))
