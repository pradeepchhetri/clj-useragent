(defproject clj-useragent "0.1.0-SNAPSHOT"
  :description "Get user-agents over APIs."
  :url "http://github.com/pradeepchhetri/clj-useragent"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [enlive "1.1.5"]
                 [compojure "1.1.9"]]
  :plugins [[lein-ring "0.8.12"]]
  :ring {:handler clj-useragent.handler/app}
  :profiles
  {:dev {:dependencies [[hiccup "1.0.5"]
                        [cheshire "5.3.1"]
                        [ring-mock "0.1.5"]
                        [javax.servlet/servlet-api "2.5"]]}})
