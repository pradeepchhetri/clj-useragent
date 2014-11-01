(ns clj-useragent.core
  (:require [clojure.string :as str]
            [net.cgrand.enlive-html :as html]))

(def ^:dynamic *base-url* "http://www.useragentstring.com")
(def ^:dynamic *all-uas* (str *base-url* "/pages/useragentstring.php"))

(defn fetch-url
  "Fetches an html page."
  [url]
  (html/html-resource (java.net.URL. url)))

(defn get-content
  "Get content from html tag."
  [html]
  (first (:content html)))

(defn get-href
  "Get href from html tag."
  [html]
  (:href (:attrs html)))

(defn extract-uas
  "Extracts all user-agents."
  [url]
  (map get-content (html/select (fetch-url url) [(html/attr= :class "unterMenuName")])))

(defn extract-uri
  "Extracts all uris."
  [url]
  (map get-href (html/select (fetch-url url) [(html/attr= :class "unterMenuName")])))

(defn get-user-agent-url
  "Returns the URL for a user-agent."
  [user-agent]
  (let [index (.indexOf (extract-uas *all-uas*) user-agent)
        user-agent-url (str *base-url* (nth (extract-uri *all-uas*) index))]
    user-agent-url))

(defn extract-versions
  "Extract all versions of a particular user-agent."
  [user-agent]
    (map get-content (html/select (fetch-url (get-user-agent-url user-agent)) [:body :h4])))

(defn extract-uas-strings
  "Extract all string of user-agent."
  [user-agent]
    (map get-content (html/select (fetch-url (get-user-agent-url user-agent)) [:body :ul :li :a])))
