(ns firebase-cljs.app
  (:refer-clojure :exclude [name])
  (:require [cljsjs.firebase]))

(defprotocol FirebaseApp

  (name [_] "Returns the Firebase Application name.")

  (options [_] "Returns the Firebase Application options.")

  (get-auth [_] "Returns the Firebase Auth service for the Firebase Application.")

  (get-db [_] "Returns the Firebase Database service for the Firebase Application.")

  (get-storage [_] "Returns the Firebase Storage service for the Firebase Application."))


(extend-type firebase.app.App

  FirebaseApp
  (name [app] (.. app -name))

  (options [app] (.. app -options))

  (get-auth [app] (.. app auth))

  (get-db [app] (.. app database))

  (get-storage [app] (.. app storage)))
