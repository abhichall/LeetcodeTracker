class Solution {
    func isValidSudoku(_ board: [[Character]]) -> Bool {
        
        //hashset for row col box
    var rowSets = Array(repeating: Set<Character>(), count: 9)
    var colSets = Array(repeating: Set<Character>(), count: 9)
    var boxSets = Array(repeating: Set<Character>(), count: 9)

    //iterate thru each cell
    for r in 0..<9 {
      for c in 0..<9 {

        let char = board[r][c]

        //skip a cell if its empty since wont coubnt for duplicatws
        if char == "." {continue}

        //check if already seen
        if rowSets[r].contains(char) { //know its invalid
          return false
        }
        rowSets[r].insert(char)

        //check col
        if colSets[c].contains(char) {
          return false
        } 
        colSets[c].insert(char)

        //check the box
        let boxIndex = (r / 3) * 3 + (c / 3)

        if boxSets[boxIndex].contains(char) {
          return false
        }
        boxSets[boxIndex].insert(char)
      }
    }
    return true
  }
}