# LRUCache
LRUCache based on LinkedHashMap ver 1.0

LRU Cache fullfilling the assumptions of implemented interfaces.

In my solution, I used LinkedHashMap which is best class (in my opinion) for this task.
LinkedHashMap keeps track of the order in which each entry is added and by default removes the oldest entry when reached to a threshold.
I choose Least Recentlu Used Cache policy, because using LRU, always ensure us that only the objects that we have used recently remain in 
cache while getting rid of objects those were not used recently. I assert that is best solution of received task.

