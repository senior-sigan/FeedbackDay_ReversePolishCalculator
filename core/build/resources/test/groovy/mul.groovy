def getSymbol() {
    return "*"
}

def apply(double... operands ) {
    return operands[0] * operands[1]
}

def getArity() {
    return 2
}

this