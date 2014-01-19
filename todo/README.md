# TODO - London FunctionalJS January Dojo, 2014

A project skeleton to be extended into a fully functional TODO application.

The skeleton is based on the London Clojure Dojo project skeleton for
January 2014, available
[here](https://github.com/christianblunden/201401ldncljdojo).

## Usage

The project requires [leiningen](http://leiningen.org/) (see link for
installation details - if you have homebrew, `brew install lein` should
get you going).

To compile the ClojureScript and launch the web server.

```bash
lein dev
```

The project will now be server on port 3000. The source files in
`src/cljs` are monitored for changes, so simply save and refresh your
browser window to see your changes.

## Task

The project skeleton contains some of the componenets for building a
simple TODO app. However, much is missing! The goal of the Dojo is too
produce a TODO app that allows you to add and remove TODO items.

If ClojureScript has made curious, here are some interesting projects to
have a look at:

- [Om](http://swannodette.github.io/2013/12/17/the-future-of-javascript-mvcs/)
  and [Cloact](http://holmsand.github.io/cloact/) are both ClojureScript
  wrappers for Facebooks React - an interesting and very efficient way
  of updating the dom tree.

- [core.async](https://github.com/clojure/core.async) is a library that
  allows you to use channel abstractions for handling data instead of
  using
  callbacks. [Here](http://ragnard.github.io/2013/10/01/clojurecup-pong-async.html)
  is a post describing how a massive multiplayer pong game was
  implemented using core.async channels (there is a link to the source
  in the post).

- If you like AngularJS,
  [several](http://keminglabs.com/blog/angular-cljs-weather-app/)
  [different](http://squirrel.pl/blog/2012/11/23/using-angular-js-with-clojurescript/)
  [people](http://www.compoundtheory.com/writing-angularjs-with-clojurescript-and-purnam/)
  have integrated with it.

- If you're into declarative programming,
  [core.logic](https://github.com/clojure/core.logic) is a brilliant
  implementation of logic programming, and
  [propaganda](https://github.com/clojure/core.logic) is an
  implementation of propagators in Clojure and ClojureScript.

## License

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
