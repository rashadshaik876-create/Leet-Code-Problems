/**
 * @param {any} obj
 * @param {any} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    // Edge cases: null, undefined, or invalid class/constructor
    if (obj === null || obj === undefined || typeof classFunction !== 'function') {
        return false;
    }

    // Traverse the prototype chain using Object.getPrototypeOf
    let currProto = Object.getPrototypeOf(obj);
    
    while (currProto !== null) {
        if (currProto === classFunction.prototype) {
            return true;
        }
        currProto = Object.getPrototypeOf(currProto);
    }

    return false;
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */
