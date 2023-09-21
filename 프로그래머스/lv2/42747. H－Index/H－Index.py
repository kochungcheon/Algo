def solution(citations):
    citations.sort()
    answer = 0
    for idx, citation in enumerate(citations):
        if citation >= len(citations) - idx:
            answer = len(citations) - idx
            break
    return answer