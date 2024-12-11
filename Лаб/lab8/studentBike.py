def assign_bikes(students, bikes):
    result = [-1] * len(students)
    assigned = set()
    distances = []

    for i, (sx, sy) in enumerate(students):
        for j, (bx, by) in enumerate(bikes):
            distance = abs(sx - bx) + abs(sy - by)
            distances.append((distance, i, j))

    distances.sort()
    for distance, student, bike in distances:
        if result[student] == -1 and bike not in assigned:
            result[student] = bike
            assigned.add(bike)

    return result

def tests():
    assert assign_bikes([], [(0, 0)]) == []  
    assert assign_bikes([(0, 0)], []) == [-1]  
    assert assign_bikes([(0, 0), (0, 0)], [(0, 0), (0, 0)]) == [0, 1]  
    assert assign_bikes([(0, 0), (2, 2)], [(1, 1)]) == [0, -1]  
    print("All tests passed!")
tests()
