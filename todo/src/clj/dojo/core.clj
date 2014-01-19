(ns dojo.core
  (:require
   [ring.util.response :refer [resource-response]]
   [compojure.core :refer [GET routes]]
   [compojure.handler :refer [api]]
   [compojure.route :refer [resources]]))

(defn app-routes []
  (routes
   (GET "/" [] (resource-response "index.html" {:root "public"}))
   (resources "/js" {:root "js"})
   (resources "/out" {:root "out"}) ; only required in dev build
   ))

(defn webapp []
  (-> (app-routes)
      api))
