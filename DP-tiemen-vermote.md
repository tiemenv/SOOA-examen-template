# Builder
* Build the complicated Consult object and prepare for scope creep

* Used to make objects from a bunch of other objects
  * Building an object from other objects
  * When you want the creation of these parts to be independent of the main object
  * Hide the creation of the parts of the client so both aren't dependent
  * The builder knows the specifics and nobody else does
# Singleton
* Repository

To make sure only one instance of a repository can be instantiated at any given time
# Observer
* Observable listview

To make sure the pane of Consults updates whenever there's a new consult added to the list

When you need many other objects to receive an update when another object changes

* Loose coupling (Publisher doens't need to know anything about the subscribers)
  * But the publisher might send updates that don't matter to certain subscribers