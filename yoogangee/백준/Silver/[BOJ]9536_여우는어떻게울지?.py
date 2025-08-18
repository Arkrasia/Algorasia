import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    sound = list(map(str, input().split()))

    while 1:
        animal = list(map(str, input().split()))

        if animal[0] == "what":
            print(" ".join(sound))
            break

        while animal[2] in sound:
            sound.remove(animal[2])