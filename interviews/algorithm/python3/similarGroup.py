#https://leetcode.com/problems/similar-string-groups/
def is_similar(s1, s2):
    if s1 == s2:
        return True
    if len(s1) != len(s2):
        return False
    diff = []
    for i in range(len(s1)):
        if s1[i] != s2[i]:
            diff.append(i)
    return len(diff) == 2 and s1[diff[0]] == s2[diff[1]] and s1[diff[1]] == s2[diff[0]]
    
def numSimilarGroups(strs):
    def dfs(node):
        visited.add(node)
        for neighbor in graph[node]:
            if neighbor not in visited:
                dfs(neighbor)
    
    n = len(strs)
    graph = {s: [] for s in strs}
    for i in range(n):
        for j in range(i+1, n):
            if is_similar(strs[i], strs[j]):
                graph[strs[i]].append(strs[j])
                graph[strs[j]].append(strs[i])
    
    visited = set()
    num_groups = 0
    for node in graph:
        if node not in visited:
            dfs(node)
            num_groups += 1
    
    return num_groups


print(numSimilarGroups(["omv","ovm"]))    
print(numSimilarGroups(["tars","rats","arts","star"]))