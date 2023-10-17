"""
 Write a method that takes in an array of positive integers in random order and returns the length of the longest sequence.
E.g.
 Input arr[]={7, 10, 12, 6, 32, 17, 5, 11, 35, 8, 31}
Output = 4
(the length of longest sequence {7, 6, 5, 8})
Examples:
{7, 6, 5, 8}
{10, 12, 11}

 Input arr[]={7, 10, 12, 6, 32, 17, 5, 11, 35, 6, 8, 31}  {7, 6, 6, 5, 8}
 First assume there is no duplicate (you could consider later)


 Input arr[]={7, 10, 12, 6, 32, 17, 5, 11, 35, 8, 31}

 // sort
    5, 6, 7, 8, 10, 11, 12, 17, 31, 32



 // iterate
    e <- 5
        curLength <- 1
        prevEle <- 5
    e <- 6
        curLength <- 2
        prevEle <- 6
    e <- 7
        curLength <- 3
        prevEle <- 7
    e <- 8
        curLength <- 4
        prevEle <- 8
    e <- 10
        maxLength <- 4
        curLength <- 1
        prevEle <- 10

        ...

    e <- 12
        maxLength <- 4
        curLength <- 3
        prevEle <- 12





let n be the length of input

sort:
    time O(nlogn)
    space: O(1)



memoization:
    time: O(N)
    space: O(N)


e <= 1000(M)

N {7, 10, 12, 6, 32, 17, 5, 11, 35, 8, 31}

bool[1001]

// iterate
    e <- 7
    bool[7] = true

C 1000
[f, f, f, f, t, t, t, t, f, t, f, t]




"""


def findLengthOfLongestSequence(input):
    if len(input) == 1:
        return 1

    # sort
    input.sort()

    maxLength = 0
    prevEle = None
    curLength = 0
    # iterate sorted input
    for e in input:
        if prevEle:
            # isConsecutive
            if e == prevEle + 1:
                curLength += 1
            else:
                maxLength = max(maxLength, curLength)
                curLength = 1
        # first element
        else:
            curLength += 1

        prevEle = e

    return max(maxLength, curLength)


if __name__ == '__main__':
    print(findLengthOfLongestSequence([]))
    print(findLengthOfLongestSequence([1]))
    print(findLengthOfLongestSequence([1, 2, 3]))
    print(findLengthOfLongestSequence([7, 10, 12, 6, 32, 17, 5, 11, 35, 8, 31]))
