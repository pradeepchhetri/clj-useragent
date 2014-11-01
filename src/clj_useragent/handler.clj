(ns clj-useragent.handler
  (:use [hiccup.core])
  (:require [cheshire.core :refer :all]
            [clj-useragent.core :refer :all]
            [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/user-agent" []
       (generate-string {:user-agent (vec (extract-uas *all-uas*))}))
  (GET "/version/:user-agent" [user-agent]
       (generate-string {:version (vec (extract-versions user-agent))}))
  (GET "/version/:user-agent/latest" [user-agent]
       (generate-string {:version (first (extract-versions user-agent))}))
  (GET "/user-agent-string/random" []
       (generate-string {:user-agent-string (rand-nth (extract-uas-strings (rand-nth (extract-uas *all-uas*))))}))
  (GET "/user-agent-string/:user-agent" [user-agent]
       (generate-string {:user-agent-string (vec (extract-uas-strings user-agent))}))
  (GET "/user-agent-string/:user-agent/random" [user-agent]
       (generate-string {:user-agent-string (rand-nth (extract-uas-strings user-agent))}))
  (GET "/user-agent-string/:user-agent/latest" [user-agent]
       (generate-string {:user-agent-string (first (extract-uas-strings user-agent))}))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
