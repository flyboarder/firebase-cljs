(ns firebase-cljs.core
  (:require [cljsjs.firebase]
            [firebase-cljs.app]
            [firebase-cljs.auth]
            [firebase-cljs.database]
            [firebase-cljs.error]
            [firebase-cljs.promise]
            [firebase-cljs.user]
            [firebase-cljs.storage]))

(def fb
  "Shortcut for `js/firebase`."
  js/firebase)

;; Helpers
(def ->cljs
  "Converts a `js object` to a `clj hashmap`."
  #(js->clj % :keywordize-keys true))

;; Functions
(defn init
  "Initializes Firebase Application. Takes `opts` map and optionally,
  an app name.

  `opts` must contain the following keys for use in the browser:

  `{:apiKey FIREBASE_API_KEY`

  ` :authDomain FIREBASE_AUTH_DOMAIN`

  ` :databaseURL FIREBASE_DATABASE_URL`

  ` :storageBucket FIREBASE_STORAGE_BUCKET}`

  `aname` may optionally be a name to reference this application, for use in
  multi-app environments.
  "
  ([opts] (.. fb (initializeApp (clj->js opts))))
  ([opts aname] (.. fb (initializeApp (clj->js opts) aname))))

(defn get-app
  "Returns the selected Firebase Application. Takes an optional `aname`
  reference to an application, for use in multi-app environments."
  ([] (.. fb app))
  ([aname] (.. fb (app aname))))

(defn get-auth
  "Returns the Firebase Auth service for the selected Firebase Application.
  Takes an optional `app` reference to an application, for use in multi-app
  environments."
  ([] (.. fb auth))
  ([app] (.. fb (auth app))))

(defn get-db
  "Returns the Firebase Database service for the selected Firebase Application.
  Takes an optional `app` reference to an application, for use in multi-app
  environments."
  ([] (.. fb database))
  ([app] (.. fb (database app))))

(defn get-storage
  "Returns the Firebase Storage service for the selected Firebase Application.
  Takes an optional `app` reference to an application, for use in multi-app
  environments."
  ([] (.. fb storage))
  ([app] (.. fb (storage app))))

;; Firebase Properties
(defn get-apps
  "Returns all the initialized Firebase Applications."
  []
  (->cljs (aget fb "apps")))

(defn get-version
  "Returns the current Firebase SDK version."
  []
  (->cljs (aget fb "SDK_VERSION")))
