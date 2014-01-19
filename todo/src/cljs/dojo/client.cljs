(ns dojo.client)

;; allows us to do print and println
(enable-console-print!)


(println "Hello world")


;; we create an atom for holding our items
(def todos
  (atom ["Learn ClojureScript"]))

(println "TODOs before swap")
;; please notice the "@" - that's how we get the content
(println (pr-str @todos))

;; conj conjoins an element to a list
(swap! todos conj "Drink beer")

(println "TODOs after swap")
(println (pr-str @todos))


;; here we grap the add-button object and register a listener
(let [add-button (.getElementById js/document "add")]
  (.log js/console add-button)
  (.addEventListener add-button
                     "click"
                     (fn [e]
                       (println "click")

                       ;; uncomment the line below to add a breakpoint
                       ;; (js* "debugger;")

                       ;; alternatively, here is some old-school debugging
                       (.log js/console e)
                       (.log js/console (.-target e)))))

;; here we grab the list and add an alement
(let [list (.getElementById js/document "list")
      new-bullet (.createElement js/document "li")]
  (set! (.-innerText new-bullet) "I'm a new element")
  (.appendChild list new-bullet))


;; so, here's what needs to be implemented:
;; - add whatever is in the input box to our todos atom list
;; - update the html list to have exactly what is in the todos atom
;; - allow us to tick things off the list
;; - styling


;; and, if you're super ambitious:
;; - explore AngularJS integration for maintaining consistency between the atom an the dom list (http://keminglabs.com/blog/angular-cljs-weather-app/)
;; - explore React for a similar binding http://swannodette.github.io/2013/12/17/the-future-of-javascript-mvcs/
;; - play with FRP in ClojureScript using Flapjax https://github.com/alandipert/flapjax-demo
