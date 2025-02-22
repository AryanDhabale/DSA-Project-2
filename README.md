# DSA-Project-2








Swap Alternate Analysis:

function swapAlternate():
    if head is null:
        return

    currentPos = head
    while currentPos is not null and currentPos.next is not null:
        temp = currentPos.next
        
        if currentPos.back is not null:
            currentPos.back.next = temp
        else:
            head = temp
        
        if temp.next is not null:
            temp.next.back = currentPos

        currentPos.next = temp.next
        temp.next = currentPos
        temp.back = currentPos.back
        currentPos.back = temp

        currentPos = currentPos.next

The loop goes through each node once, so the time complexity is O(n), where n is the number of nodes in the list.


Reverse List Analysis:

function reverseList():
    if head is null:
        return
    
    temp = null
    currentPos = head

    while currentPos is not null:
        temp = currentPos.next
        currentPos.next = currentPos.back
        currentPos.back = temp

        currentPos = currentPos.back
        
        if temp is not null:
            head = temp

The loop goes through each node once, so the time complexity is O(n), where n is the number of nodes in the list.


Delete Subsection Analysis:

function deleteSubsection(lower, upper):
    if head is null:
        return
    
    while head is not null and head.info is between lower and upper:
        head = head.next
        if head is not null:
            head.back = null

    currentPos = head
    while currentPos is not null and currentPos.next is not null:
        if currentPos.next.info is between lower and upper:
            currentPos.next = currentPos.next.next
            if currentPos.next is not null:
                currentPos.next.back = currentPos
        else:
            currentPos = currentPos.next

Both loops go through the list once, so the time complexity is O(n), where n is the number of nodes in the list. Additionally the loops are not nested.