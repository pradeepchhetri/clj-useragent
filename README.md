# clj-useragent

A Clojure library designed to get list of user-agents over APIs.

## API Endpoints

| Endpoint                                 | Response                                                    |
| -----------------------------------------|-------------------------------------------------------------|
| /user-agent                              | List of available user-agents                               |
| /version/#{user-agent}                   | List all the versions of a particular useragent.            |
| /version/#{user-agent}/latest            | List the latest version of a particular useragent.          |
| /user-agent-string/#{user-agent}         | List all useragent string of a particular useragent.        |
| /user-agent-string/#{user-agent}/random  | List a random useragent string of a particular useragent.   |
| /user-agent-string/#{user-agent}/latest  | List the latest version of useragent string of a useragent. |
| /user-agent-string/random                | List a random useragent string of a random useragent.       |
