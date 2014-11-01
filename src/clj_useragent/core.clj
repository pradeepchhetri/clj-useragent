(ns clj-useragent.core
  (:require [clojure.string :as str]
            [cheshire.core :as json]
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
