(ns firebase-cljs.auth.error
  (:require [cljsjs.firebase]))

(defprotocol FirebaseAuthError

  (code [_] "Returns the Firebase Auth Error unique error code.")

  (message [_] "Returns the Firebase Auth Error complete error message."))

(extend-type firebase.auth.Error

  FirebaseAuthError
  (code [err] (aget err "code"))

  (message [err] (aget err "message")))
